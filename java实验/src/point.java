
public class point {
	double x,y,z;
	point(double _x,double _y,double _z){
	x=_x;
	y=_y;
	z=_z;
}
void setx(double _x)
    {
    x=_x;
    }
   double getDistance(point p)
   {
	   return(x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z);
   }}
 

