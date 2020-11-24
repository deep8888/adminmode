<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="container">
<br/><br/><br/><br/>
  <h2>Striped Rows</h2>
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>Name</th>
      	<th>Category</th>
      	<th>Price</th>
      	<th>Manufacturer</th>
      	<th>UnitInStock</th>
      	<th>Description</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var= "product" items="${products }">
    	<tr>
    	 	<td> ${product.name}</td>
    	 	<td> ${product.category}</td>
    	 	<td> ${product.price}</td>
    	 	<td> ${product.manufacturer}</td>
    	 	<td> ${product.unitInStock}</td>
    	 	<td> ${product.description}</td>
    	</tr>
    	
    </c:forEach>
    </tbody>
  </table>
</div>
	
  