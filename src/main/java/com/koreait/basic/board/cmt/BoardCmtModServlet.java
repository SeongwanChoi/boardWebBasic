package com.koreait.basic.board.cmt;

import com.koreait.basic.Utils;
import com.koreait.basic.board.cmt.model.BoardCmtEntity;
import com.koreait.basic.dao.BoardCmtDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/cmt/mod")
public class BoardCmtModServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardCmtEntity entity = new BoardCmtEntity();

        entity.setCtnt(req.getParameter("ctnt"));
        entity.setIcmt(Utils.getParameterInt(req, "icmt"));
        int iboard = Utils.getParameterInt(req, "iboard");
        entity.setIboard(iboard);
        entity.setWriter(Utils.getLoginUserPk(req));

        int result = BoardCmtDAO.updBoardCmt(entity);

        switch (result) {
            case 1:
                res.sendRedirect("/board/detail?iboard=" + iboard);
                break;
            default:
                break;
        }
    }
}
