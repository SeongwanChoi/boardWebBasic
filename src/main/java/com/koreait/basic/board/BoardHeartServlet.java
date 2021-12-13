package com.koreait.basic.board;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardHeartEntity;
import com.koreait.basic.dao.BoardHeartDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/heart")
public class BoardHeartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String proc = req.getParameter("proc");
        int iboard = Utils.getParameterInt(req, "iboard");
        int iuser = Utils.getLoginUserPk(req);

        System.out.println("proc : " + proc);
        System.out.println("iboard : " + iboard);
        System.out.println("iuser : " + iuser);

        BoardHeartEntity entity = new BoardHeartEntity();
        entity.setIboard(iboard);
        entity.setIuser(iuser);

        switch (proc) {
            case "1":
                BoardHeartDAO.insBoardHeart(entity);
                break;
            case "2":
                BoardHeartDAO.delBoardHeart(entity);
                break;
        }
        res.sendRedirect("/board/detail?iboard=" + iboard);
    }
}
