package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FriendsDB {
    public static FriendsDB friendsDB = new FriendsDB();
    private static Connection cn = PortalRepository.getInstance().getConnection();

    private FriendsDB() {}

    public static FriendsDB getInstance() {
        return friendsDB;
    }

    public boolean isFriend(int id1, int id2) {
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM friends f " +
                    "JOIN friends c ON (f.uid1 = c.uid2)" +
                    " WHERE f.uid2 = c.uid1 AND f.uid1 = ? AND f.uid2 = ?");
            ps.setInt(1, id1);
            ps.setInt(2, id2);
            ResultSet rs = ps.executeQuery();
            boolean friend = false;
            if (rs.next()) {
                friend = true;
            }
            rs.close();
            return friend;
        } catch (Exception e ){
            e.printStackTrace();
        }
        return false;
    }

    public void sendRequest(){

    }
}
