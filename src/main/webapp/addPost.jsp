<%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 21-Jan-21
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<form action="posts" method="post">
    Title: <input type="text" name="title"> <br>
    Content: <textarea name="content" cols="50" rows="30"></textarea> <br>
    Visibility: <br>
    Internet <input type="radio" name="visibility" value="0"> <br>
    Portal <input type="radio" name="visibility" value="1"> <br>
    Friends  <input type="radio" name="visibility" value="0"> <br>
    <input type="submit" value="Add">
</form>
