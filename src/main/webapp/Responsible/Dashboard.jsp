<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.entity.PromoEntity" %>
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


<div class="flex h-screen flex-col items-center justify-center space-y-6 bg-gray-100 px-4 sm:flex-row sm:space-x-6 sm:space-y-0">
    <%
        try{
            List<PromoEntity> promotions = (ArrayList<PromoEntity>) request.getAttribute("Promotions");

            if(promotions==null){
                out.print("nothing to print");
            }else{


                for(PromoEntity s:promotions){   %>

    <div class="w-full max-w-sm overflow-hidden rounded-lg bg-white shadow-md duration-300 hover:scale-105 hover:shadow-xl">
        <svg xmlns="http://www.w3.org/2000/svg" class="mx-auto mt-8 h-16 w-16 text-red-500" viewBox="0 0 20 20"
             fill="currentColor">
            <path fill-rule="evenodd"
                  d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z"
                  clip-rule="evenodd"/>
        </svg>
        <h1 class="mt-2 text-center text-2xl font-bold text-gray-500">Cancel</h1>
        <p class="my-4 text-center text-sm text-gray-500">Just a small miss, 2/5 Tasks</p>
        <div class="space-x-4 bg-gray-100 py-4 text-center">
            <button class="inline-block rounded-md bg-red-500 px-10 py-2 font-semibold text-red-100 shadow-md duration-75 hover:bg-red-400">
                Cancel
            </button>
            <button class="inline-block rounded-md bg-green-500 px-6 py-2 font-semibold text-green-100 shadow-md duration-75 hover:bg-green-400">
                Try Again
            </button>
        </div>
    </div>

    <% }
    }
    } catch (Exception e) {
        e.getStackTrace();
    }

    %>

</div>


</body>
</html>