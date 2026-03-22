package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Location;
import com.model.RoomImages;
import com.model.Rooms;
import com.utility.DBConnection;

public class RoomDao {

    // 🔹 Get all available rooms
    public List<Rooms> getAllRooms(){

        List<Rooms> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM rooms WHERE status='Available'";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Rooms r = new Rooms();

                r.setRoomId(rs.getInt("roomid"));
                r.setTitle(rs.getString("title"));
                r.setDescription(rs.getString("description"));
                r.setPrice(rs.getDouble("price"));
                r.setSharing_type(rs.getString("sharing_type"));
                r.setAvailablerooms(rs.getInt("availablerooms"));
                r.setStatus(rs.getString("status"));
                r.setLocationId(rs.getInt("locationid"));
                

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 Get room by ID
    public Rooms getRoomById(int roomId){

        Rooms r = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM rooms WHERE roomid=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roomId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                r = new Rooms();

                r.setRoomId(rs.getInt("roomid"));
                r.setTitle(rs.getString("title"));
                r.setDescription(rs.getString("description"));
                r.setPrice(rs.getDouble("price"));
                r.setSharing_type(rs.getString("sharing_type"));
                r.setAvailablerooms(rs.getInt("availablerooms"));
                r.setStatus(rs.getString("status"));
                r.setLocationId(rs.getInt("locationid"));
            
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return r;
    }

    // 🔹 Add new room
    public int addRoom(Rooms r){

        int roomId = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO rooms(title,description,price,sharing_type,availablerooms,status,locationid) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            
            ps.setString(1, r.getTitle());
            ps.setString(2, r.getDescription());
            ps.setDouble(3, r.getPrice());
            ps.setString(4, r.getSharing_type());   // sharing_type
            ps.setInt(5, r.getAvailablerooms());    // availablerooms
            ps.setString(6, r.getStatus());         // status
            ps.setInt(7, r.getLocationId());        // locationid


            int i = ps.executeUpdate();

            if(i > 0){

                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()){
                    roomId = rs.getInt(1);
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return roomId;
    }
    //select location as dynamic
    public List<Location> getAllLocations() {
        List<Location> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM location")) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Location loc = new Location();
                loc.setLocationId(rs.getInt("locationid"));
                loc.setCity(rs.getString("city"));
                loc.setArea(rs.getString("area"));
                loc.setState(rs.getString("state"));
                loc.setPincode(rs.getString("pincode"));
                list.add(loc);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    // 🔹 Save room images
    public boolean addRoomImages(RoomImages img){

        boolean f = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO room_images(roomid,img1,img2,img3) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, img.getRoomId());
            ps.setString(2, img.getImgPath1());
            ps.setString(3, img.getImgPath2());
            ps.setString(4, img.getImgPath3());

            int i = ps.executeUpdate();

            if(i == 1){
                f = true;
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return f;
    }
		public List<String> getRoomImagesByRoomId(int roomId) {
		    List<String> images = new ArrayList<>();
		    try (Connection con = DBConnection.getConnection();
		         PreparedStatement ps = con.prepareStatement("SELECT img1, img2, img3 FROM room_images WHERE roomid=?")) {
		        ps.setInt(1, roomId);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            if (rs.getString("img1") != null) images.add(rs.getString("img1"));
		            if (rs.getString("img2") != null) images.add(rs.getString("img2"));
		            if (rs.getString("img3") != null) images.add(rs.getString("img3"));
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return images;
		}

	}

