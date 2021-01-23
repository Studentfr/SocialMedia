package db;

import javafx.geometry.Pos;
import models.Post;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public List<Post> getPostsList(int userId, boolean authorized) {
        try {
            String sqlAuthor = "SELECT DISTINCT post_id, title, content FROM posts p\n" +
                    "LEFT JOIN friends f ON (f.uid1 = p.author_id)\n" +
                    "LEFT JOIN friends c On (c.uid2 = p.author_id)\n" +
                    "WHERE (c.uid1 = f.uid2 AND c.uid1 = ?) OR visibility < 2";
            String unAuth = "SELECT post_id, title, content FROM posts\n" +
                    "WHERe visibility = 0";
            PreparedStatement ps;
            if (authorized) {
                ps = cn.prepareStatement(sqlAuthor);
                ps.setInt(1, userId);
            } else ps = cn.prepareStatement(unAuth);
            ResultSet res = ps.executeQuery();
            List<Post> posts = new LinkedList<>();
            while (res.next()) {
                Post p = new Post();
                p.setId(res.getInt(1));
                p.setTitle(res.getString(2));
                p.setContent(res.getString(3));
                posts.add(p);
            }
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
