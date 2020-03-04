package eg.edu.alexu.csd.datastructure.iceHockey.cs22;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ThePhoto implements IPlayersFinder {
    private char[] photoArray;
    private int chars;
    private int boxes = 0;


    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        if(photo.length==0||threshold<=0||team<0||team>9)
            return null;
        else if(photo[0].length()==0)
            return null;
        setPhoto(photo);
        Point[] coords = new Point[(int) (10 + ((photo.length * photo[0].length()) / threshold))];
        photo=null;
        int counter = 0;
        int[] arrayOfFoundIndexes=new int[photoArray.length];
        for (int i = 0; i < photoArray.length; i++) {
            while(i<photoArray.length) {
                if (searchArray(arrayOfFoundIndexes, i)) {

                    break;
                }
                i++;
            }
            if(i==photoArray.length)
                break;
            ArrayList<Integer> indexes = new ArrayList<>();
            if (photoArray[i]-'0' == team) {
                indexes.add(i);
                lookForAdjacent(indexes, i);
                boxes = indexes.size();
                if (boxes * 4 >= threshold && checkPoint(getPoint(indexes),coords,counter)){
                    coords[counter] = getPoint(indexes);
                    counter++;
                }
                else
                addToArray(indexes,arrayOfFoundIndexes);
                indexes.clear();

                }

            }

        return sortPoints(coords,counter);


    }

    public void lookForAdjacent(ArrayList<Integer> indexes, int index) {
        if (index+1<photoArray.length&&(index + 1) % chars != 0 && photoArray[index] == photoArray[index + 1]) {
            if(addIndex(indexes, index + 1))
                lookForAdjacent(indexes, index + 1);
        }
        if (index-1>=0&&(index - 1) % (chars) != (chars-1) && photoArray[index] == photoArray[index - 1]) {
            if(addIndex(indexes, index - 1))
                lookForAdjacent(indexes, index - 1);
        }
        int jump = index + chars;
        if (jump < photoArray.length) {
            if (photoArray[jump] == photoArray[index]) {
                if(((jump-1)%(chars)!=chars-1)&&(photoArray[jump-1]==photoArray[jump])&&addIndex(indexes,jump)) {
                    addIndex(indexes,jump-1);
                    lookForAdjacent(indexes, jump - 1);
                }
                addIndex(indexes, jump);
                lookForAdjacent(indexes, jump);
            }
        }
        jump=index-chars;
        if(index-chars>=0){
            if (photoArray[jump] == photoArray[index]&&addIndex(indexes,jump)) {
                if(jump-1>=0&&((jump-1)%(chars)!=chars-1)&&(photoArray[jump-1]==photoArray[jump])) {
                    addIndex(indexes,jump-1);
                    lookForAdjacent(indexes, jump - 1);
                }
                addIndex(indexes, jump);
                lookForAdjacent(indexes, jump);
            }

        }
    }

    private void setPhoto(String[] photo) {
            int lines = photo.length;
            this.chars = photo[0].length();
            int size = lines * chars;
            photoArray = new char[size];
            int count = 0;
            for (int y = 0; y < lines; y++)
                for (int x = 0; x < chars; x++) {
                    photoArray[count] = photo[y].charAt(x);
                    count++;
                    //Now the 2D Array is converted to 1D array.

                }

    }


    private boolean addIndex(ArrayList<Integer> arr, int index) {
        for (int i = 0; i < arr.size(); i++)
            if (index == arr.get(i))
                return false;
        arr.add(index);
        return true;
    }

    public Point getPoint(ArrayList<Integer> indexes){
        Point point =new Point();
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        for(int i=0;i<indexes.size();i++){
            int rows=indexes.get(i)/chars;
            rows=2*rows+1;
            int cols=indexes.get(i)%chars;
            cols=2*cols+1;
            if(rows>maxX)
                maxX=rows;
            if(rows<minX)
                minX=rows;
            if(cols>maxY)
                maxY=cols;
            if(cols<minY)
                minY=cols;
        }
        point.y=(maxX+minX)/2;
        point.x=(maxY+minY)/2;

        return point;
    }
    public boolean checkPoint(Point point,Point[] coords,int counter){
        if(coords[0]==null)
            return true;
        for(int i=0;i<counter;i++){
            if(point.x==coords[i].x)
                if(point.y==coords[i].y)
                    return false;
        }
        return true;
    }
    public Point[] sortPoints(Point[] coords,int counter){
        if(coords[0]!=null) {
            for (int i = 0; i < counter - 1; i++)
                for (int j = 0; j < counter - 1; j++) {
                    if (coords[j].x > coords[j + 1].x) {
                        Point temp = coords[j + 1];
                        coords[j + 1] = coords[j];
                        coords[j] = temp;
                    } else if ((coords[j].x == coords[j + 1].x) && (coords[j].y > coords[j + 1].y)) {
                        Point temp = coords[j + 1];
                        coords[j + 1] = coords[j];
                        coords[j] = temp;

                    }
                }
            return coords;
        }
        System.out.println("No players");
        return null;
    }
    public boolean searchArray(int[] indexes,int index){
        if(indexes[0]==0&&indexes[1]==0)
            return true;

        for(int i=0;i<indexes.length;i++)
            if(indexes[i]==index)
                return false;


        return true;
    }
    public void addToArray(ArrayList<Integer> indexes,int[]array){
        if(array[1]==0){
            for(int i=0;i<indexes.size();i++)
                array[i]=indexes.get(i);
        }
        else{
            int i=2;
            while(i<array.length&&array[i]!=0){
                i++;
            }
            for(int c=0;c<indexes.size();c++){
                array[i]=indexes.get(c);
                i++;
            }


        }

    }


}


