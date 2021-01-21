package db;

import java.sql.*;

public class PostsDB {
    public static PostsDB postsDB = new PostsDB();
    private static Connection cn = PortalRepository.getInstance().getConnection();

    private PostsDB() {}

    public static PostsDB getInstance() {
        return postsDB;
    }

    public void addPost(String title, String content, int visibility, int author_id) {
        try {
            PreparedStatement ps = cn.prepareStatement
                    ("INSERT INTO posts (title, content, visibility, author_id) VALUES (?, ?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, visibility);
            ps.setInt(4, author_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
