package eg.edu.alexu.csd.datastructure.iceHockey.cs22;

import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       ThePhoto photo = new ThePhoto();
        Point[] points=new Point[20];
                points=photo.findPlayers(new String[]{
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
                "8PK8H8T8888TQR8"
    },8,9);

        for(int i=0;i<points.length;i++)
            if(points[i]!=null)
                System.out.println("( "+points[i].x+" , "+points[i].y+" )");


    }
}
