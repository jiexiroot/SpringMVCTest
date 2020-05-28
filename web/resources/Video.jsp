<%--
  Created by IntelliJ IDEA.
  User: GOU
  Date: 2020/5/26
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/node_modules/cc-player/dist/cc-player.min.js"></script>
    <style>
        .video-container {
            margin-bottom: 20px;
        }

        .controls {
            margin: 30px 0;
        }
    </style>
    <title>Title</title>

</head>
<body>
    <div id="video-1" class="video-container">
    视频播放容器
    </div>
    <button onclick="playVideo('DA2D015D371417299C33DC5901307461')">播放视频一</button>

    <script>

        var container = $('#video-1');
        var player = new CCPlayer.init(container, {
            siteid: 'ED9742DB71BAEFEF',
            playerid: '642FA1ABFCD4C9B0',
            width: 600,
            height: 400
        });


        function playVideo(vid) {
            player.play(vid);
        }
    </script>
</body>
</html>
