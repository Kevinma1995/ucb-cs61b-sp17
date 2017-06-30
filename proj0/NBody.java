/**
 * This class is a program for UC Berkley CS 61B project 0.
 * @author Ziyi Yan
 */
public class NBody {
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		in.readLine();  // Skip the first line.

		return in.readDouble();
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);

		int numberOfPlants = in.readInt();

		in.readDouble();  // Skip radius.

		Planet[] planets = new Planet[numberOfPlants];
		for (int i = 0; i < numberOfPlants; i++) {
			planets[i] = readPlanet(in);
		}

		return planets;
	}

	public static Planet readPlanet(In in) {
		double xPos = in.readDouble();
		double yPos = in.readDouble();
		double xVel = in.readDouble();
		double yVel = in.readDouble();
		double mass = in.readDouble();
		String imgFileName = in.readString();
		return new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		Planet[] plants = readPlanets(filename);
		double radius = readRadius(filename);

		drawBackground(radius);

		drawPlants(plants);

		StdDraw.show(1000);

		for (int t = 0; t < T; t++) {
			double[] xForces = new double[plants.length];
			double[] yForces = new double[plants.length];

			for (int i = 0; i < plants.length; i++) {
				xForces[i] = plants[i].calcNetForceExertedByX(plants);
				yForces[i] = plants[i].calcNetForceExertedByY(plants);
			}

			for (int i = 0; i < plants.length; i++) {
				plants[i].update(dt, xForces[i], yForces[i]);
			}

			drawBackground(radius);
			drawPlants(plants);
			StdDraw.show(10);

			t += dt;
		}


		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}

	private static void drawBackground(double radius) {
		String background = "images/starfield.jpg";
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, background);
	}

	private static void drawPlants(Planet[] plants) {
		for (Planet p : plants) {
			p.draw();
		}
	}
}
