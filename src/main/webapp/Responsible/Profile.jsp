<%@ page import="metier.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.entity.StoreEntity" %>
<%@ page import="metier.entity.CategoryEntity" %>
<%@ page import="metier.entity.SubcategoryEntity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css"/>
  <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</head>
<body>


<div class="bg-gray-200 font-sans h-screen w-full flex flex-row justify-center items-center">
  <%
    try {
      UsersEntity user = (UsersEntity) request.getAttribute("responsible");
      if(user==null){
        out.print("nothing to print");
      }else{
        %>
  <div class="card w-96 mx-auto bg-white  shadow-xl hover:shadow">
    <img class="w-32 mx-auto rounded-full -mt-20 border-8 border-white" src="https://avatars.githubusercontent.com/u/67946056?v=4" alt="">
    <div class="text-center mt-2 text-3xl font-medium"><%= user.getFullname()%></div>
    <div class="text-center mt-2 font-light text-sm"><%= user.getEmail() %></div>
    <div class="text-center font-normal text-lg"> <%= user.getCategoryByIdcategory().getName() %> </div>

    <hr class="mt-8">
    <div class="flex p-4">
      <div class="w-1/2 text-center">
        <a href="${pageContext.request.contextPath}/Login/set-password.jsp" class="font-bold">Reset password</a>
      </div>
      <div class="w-0 border border-gray-300">

      </div>
      <div class="w-1/2 text-center">
        <a href="${pageContext.request.contextPath}/promotion/displayPromotion" class="font-bold">Back</a>
      </div>
    </div>
  </div>


  <%
     }
  }catch (Exception e) {
    e.getStackTrace();
  }

  %>

</div>




</body>
</html>