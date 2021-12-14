<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:choose>
    <c:when test="${requestScope.maxPageNum == 0}">
        <div>글이 없습니다.</div>
    </c:when>
    <c:otherwise>
        <div>
            <table id="boardTable">
                <colgroup>
                    <col width="20%">
                    <col>
                    <col>
                    <col width="100px">
                    <col>
                </colgroup>
                <tr>
                    <th>no</th>
                    <th>title</th>
                    <th>hits</th>
                    <th>writer</th>
                    <th>reg-datetime</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <c:set var="eachTitle" value="${fn:replace(fn:replace(item.title, '>', '&gt;'), '<', '&lt;')}"/>
                    <c:if test="${param.searchText != null && (param.searchType == 1 || param.searchType == 3 || param.searchType == 5)}">
                        <c:set var="eachTitle" value="${fn:replace(eachTitle, param.searchText, '<mark>' += param.searchText += '</mark>')}" />
                    </c:if>

                    <c:set var="eachWriterNm" value="${item.writerNm}" />
                    <c:if test="${param.searchText != null && (param.searchType == 4 || param.searchType == 5)}">
                        <c:set var="eachWriterNm" value="${fn:replace(eachWriterNm, param.searchText, '<mark>' += param.searchText += '</mark>')}" />
                    </c:if>

                    <tr class="record" onclick="moveToDetail(${item.iboard});">
                        <td>${item.iboard}</td>
                        <td>${eachTitle}</td>
                        <td>${item.hit}</td>
                        <td>${eachWriterNm}</td>
                        <td>${item.rdt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="pageContainer">
            <c:set var="selectedPage" value="${param.page == null ? 1 : param.page}" />
            <c:forEach var="page" begin="1" end="${maxPageNum}">
                <div><a href="/board/list?page=${page}&searchType=${param.searchType}&searchText=${param.searchText}&rowCnt=${param.rowCnt}"><span class="${selectedPage == page ? 'selected' : ''}"><c:out value="${page}"/></span></a></div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>