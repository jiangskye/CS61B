public class NBody {
    public static double readRadius(String fileName)
    {
        In in = new In(fileName);
        in.readInt();
        double raidus = in.readDouble();
        return raidus;
    } 
    
    public static Body[] readBodies(String fileName)
    {
        In in  = new In(fileName);
        int numOfBodies = in.readInt();
        Body[] bodies = new Body[numOfBodies];
        in.readDouble();
        for (int i = 0; i < numOfBodies; i++)
        {
            bodies[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(),
            in.readDouble(), in.readDouble(), in.readString());
        }
        return bodies;
    }

    public static void main(String[] args)
    {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];

        double radius = readRadius(fileName);
        Body[] bodies = readBodies(fileName);
        // StdOut.printf("%f\n", raidus);

        // Drawing the background
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        Double[] xForces = new Double[bodies.length];
        Double[] yForces = new Double[bodies.length];
        
        double responseTime = 0;
        while (responseTime < T)
        {
            for (int i = 0; i < bodies.length; i++)
            {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            
            /* Draw all the bodies */
            for (Body b: bodies)
            {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            responseTime += dt;
        }
        // print the universe
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) 
        {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }    
    }
    
}
