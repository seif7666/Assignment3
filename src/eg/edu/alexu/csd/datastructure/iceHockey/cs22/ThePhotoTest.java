package eg.edu.alexu.csd.datastructure.iceHockey.cs22;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ThePhotoTest {
    private ThePhoto photo=new ThePhoto();

    @org.junit.Test
    public void findPlayers() {
        assertNull(photo.findPlayers(new String[]{},4,16));
        assertNull(photo.findPlayers(new String[]{"hello","Hello"},-1,16));
        Point[] point=photo.findPlayers(new String[]{
                "33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"},3,16);
        int x=point[0].x;
        int y=point[0].y;
        assertEquals(4,x);
        assertEquals(5,y);


       point=photo.findPlayers(new String[]{
               "44444H44S4",
               "K444K4L444",
               "4LJ44T44XH",
               "444O4VIF44",
               "44C4D4U444",
               "4V4Y4KB4M4",
               "G4W4HP4O4W",
               "4444ZDQ4S4",
               "4BR4Y4A444",},4,16);
         x=point[0].x;
         y=point[0].y;
        assertEquals(3,x);
        assertEquals(8,y);
        assertEquals(16,point[3].x);
        assertEquals(3,point[3].y);

        point=photo.findPlayers(new String[]{
                "8D88888J8L8E888",
                "88NKMG8N8E8JI88",
                "888NS8EU88HN8EO",
                "LUQ888A8TH8OIH8",
                "888QJ88R8SG88TY",
                "88ZQV88B88OUZ8O",
                "FQ88WF8Q8GG88B8",
                "8S888HGSB8FT8S8",
                "8MX88D88888T8K8",
                "8S8A88MGVDG8XK8",
                "M88S8B8I8M88J8N",
                "8W88X88ZT8KA8I8",
                "88SQGB8I8J88W88",
                "U88H8NI8CZB88B8",
                "8PK8H8T8888TQR8"},8,9);
        x=point[0].x;
        y=point[0].y;
        assertEquals(1,x);
        assertEquals(17,y);
        assertEquals(9,point[6].x);
        assertEquals(2,point[6].y);



        System.out.println("The findPlayers method is working nice");
    }

    @org.junit.Test
    public void getPoint() {
        photo.findPlayers(new String[]{
                "33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"},3,16);

        ArrayList<Integer> x=new ArrayList<>();
        for(int i=1;i<=5;i++)//1->according to the findPlayers method as setter of array is there.
            x.add(i);
        int coordX=photo.getPoint(x).x;
        int coordY=photo.getPoint(x).y;

        assertEquals(7,coordX);
        assertEquals(1,coordY);

        System.out.println("The getPoint method is working nice");
    }

    @org.junit.Test
    public void checkPoint() {
        Point[] points= photo.findPlayers(new String[]{
                "33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"},3,16);
        assertTrue(photo.checkPoint(new Point(0,0),points,3));
        assertFalse(photo.checkPoint(new Point(13,9),points,3));

        System.out.println("The checkPoint method is working nice");


    }

    @org.junit.Test
    public void sortPoints() {
        Point[] points=new Point[]{new Point(5,1),
                new Point(1,1),
                new Point(-5,2),
                new Point(4,9),
                new Point(1,11)};
        points=photo.sortPoints(points,5);
        int x=points[0].x;
        assertEquals(-5,x);
        int y=points[0].y;
        assertEquals(2,y);

        assertEquals(1,points[1].x);
        assertEquals(1,points[1].y);

        assertEquals(1,points[2].x);
        assertEquals(11,points[2].y);

        assertEquals(5,points[4].x);
        assertEquals(1,points[4].y);

        System.out.println("The SortArray method is working nice");

    }

    @org.junit.Test
    public void searchArray() {
        int[] array=new int[6];
        assertTrue(photo.searchArray(array,6));
        array=new int[]{1,2,3,4,5,6};
        assertFalse(photo.searchArray(array,6));
        assertTrue(photo.searchArray(array,10));

        System.out.println("The searchArray method is working nice");

    }
}