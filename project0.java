
import java.util.ArrayList;
import java.math.*;
public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	
	public Planet(double xP, double yP,double xV, double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
		
	}
	
	public double calcDistance(Planet p){
		double r=Math.sqrt(((xxPos-p.xxPos)*(xxPos-p.xxPos))+((yyPos-p.yyPos)*(yyPos-p.yyPos)));//因为是从属于class的函数，所以所有xxPos等都指代class里的那个
		return  r;
		
	}
	
	public double calcForceExertedBy(Planet p){
		double G=6.67 * Math.pow(10,-11);
		double r =calcDistance(p);
		double rSquared= r*r;
		double F= G*mass*p.mass*rSquared;
		return F;
		
	}
	
	public double calcForceExertedByX(Planet p){
		double dx = Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos));
		double F = calcForceExertedBy(p);
		double r = calcDistance(p);
		double Fx=F*dx/r;
		return Fx;
		
	}
	
	public double calcForceExertedByy(Planet p){
		double dy = Math.sqrt((yyPos-p.yyPos)*(yyPos-p.yyPos));
		double F = calcForceExertedBy(p);
		double r = calcDistance(p);
		double Fy=F*dy/r;
		return Fy;
		
	}
	
	public double calcNetForceExertedByX(Planet[]p){
		double netForceX = 0;
		for (int i=0; i<p.length; i++){
			
			if (p[i].imgFileName == imgFileName){
				netForceX += 0;
			}
			else{
				netForceX += netForceX+calcForceExertedByX(p[i]);
			}	
			
		}
		return netForceX;	
		
	}
	
	public double calcNetForceExertedByY(Planet[]p){
		double netForceY=0;
		for (int i=0;i<p.length;i++){
			if (p[i].imgFileName==imgFileName){
				netForceY = netForceY + calcForceExertedBy(p[i]);
			}
			else{
				netForceY = netForceY + calcForceExertedByy(p[i]);
				
			}
			
		}
		return netForceY;
	}
	
    public void update (double dt, double fX, double fY){
    	double aX=fX/ mass;
    	double aY=fY/mass;
    	xxVel=xxVel+aX*dt;
    	yyVel=yyVel+aY*dt;
    	xxPos=xxPos+xxVel*dt;
    	yyPos=yyPos+yyVel*dt;
  	
    }

    
	
	
	public static void main(String[] args) {
        Planet p = new Planet(1,2,3,4,5,"pigli");
        Planet pp = new Planet(p);
        

	}
	
	


	
}
