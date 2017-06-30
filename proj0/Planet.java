import java.lang.Math;

public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = xxPos - p.xxPos;
		double dy = yyPos - p.yyPos;
		return Math.pow(dx * dx + dy * dy, 1.0 / 2);
	}

	public double calcForceExertedBy(Planet p) {
		if (equals(p)) {
			return 0;
		}

		double r = calcDistance(p);
		return G * mass * p.mass / Math.pow(r, 2);
	}

	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double r = calcDistance(p);
		double f = calcForceExertedBy(p);
		return f * dx / r;
	}

	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double f = calcForceExertedBy(p);
		return f * dy / r;
	}

	public double calcNetForceExertedByX(Planet[] plants) {
		double netForce = 0;
		for (Planet p : plants) {
			if (equals(p)) {
				continue;
			}
			netForce += calcForceExertedByX(p);
		}
		return netForce;
	}

	public double calcNetForceExertedByY(Planet[] plants) {
		double netForce = 0;
		for (Planet p : plants) {
			if (equals(p)) {
				continue;
			}
			netForce += calcForceExertedByY(p);
		}
		return netForce;
	}

	public void update(double dt, double fX, double fY) {
		double accelerationByX = calcAcceleration(fX);
		double accelerationByY = calcAcceleration(fY);
		xxVel += accelerationByX * dt;
		yyVel += accelerationByY * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}

	private double calcAcceleration(double f) {
		return f / mass;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}
