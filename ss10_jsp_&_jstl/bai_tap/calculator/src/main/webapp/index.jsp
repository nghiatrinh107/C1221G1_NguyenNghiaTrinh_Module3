<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/13/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form method="post" action="/calculate">
    <fieldset>
      <legend>Calculator</legend>
      <table>
        <tr>
          <td>First operand: </td>
          <td><input name="first-operand" type="text"/></td>
        </tr>
        <tr>
          <td>Operator: </td>
          <td>
            <select name="operator">
              <option value="+">Addition</option>
              <option value="-">Subtraction</option>
              <option value="*">Multiplication</option>
              <option value="/">Division</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>Second operand: </td>
          <td><input name="second-operand" type="text"/></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Calculate"/></td>
        </tr>
      </table>
    </fieldset>
  </form>
  <c:if test="${!empty result}">
    <h2>Result: </h2>
    <c:choose>
      <c:when test="${!message.equals('')}">
        <h2>${message}</h2>
      </c:when>
      <c:otherwise>
        <h3>${firstOperand} ${operator} ${secondOperand} = ${result}</h3>
      </c:otherwise>
    </c:choose>
  </c:if>
  </body>
</html>
