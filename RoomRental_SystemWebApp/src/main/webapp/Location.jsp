<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
e.

public boolean addLocation(Location l){

boolean status=false;

try{

Connection con = DBConnection.getConnection();

String sql="insert into location(city,area,state,pincode) values(?,?,?,?)";

PreparedStatement ps=con.prepareStatement(sql);

ps.setString(1,l.getCity());
ps.setString(2,l.getArea());
ps.setString(3,l.getState());
ps.setString(4,l.getPincode());

int i = ps.executeUpdate();

if(i>0){
status=true;
}

}catch(Exception e){
e.printStackTrace();
}

return status;

}
