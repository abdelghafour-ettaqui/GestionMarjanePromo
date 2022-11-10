
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<div class="container col-md-8 col-md-offset-3" style="overflow: auto">

    <body class="antialiased bg-slate-200">
    <div class="max-w-lg mx-auto my-10 bg-white p-8 rounded-xl shadow shadow-slate-300">
        <h1 class="text-4xl font-medium">Login</h1>
        <p class="text-slate-500">Hi, Welcome back ?</p>


        <form action="<%=request.getContextPath()%>/updatePassword" method="post" class="my-10">
            <div class="flex flex-col space-y-5">
                <label for="password">
                    <p class="font-medium text-slate-700 pb-2">Password</p>
                    <input id="password" name="password" type="password" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter email address">
                </label>
                <label for="confirmPassword">
                    <p class="font-medium text-slate-700 pb-2">Confirm password</p>
                    <%
                        try {
                            String idUser = (String) request.getAttribute("idUser");
                            if(idUser.equals(null)){
                                out.print("nothing to print");
                            }else{
                                 %>

                    <input type="hidden" value="<%=  idUser %>" />

                    <%
                    }
                    }catch (Exception e) {
                        e.getStackTrace();
                    }

                    %>
                    <input id="confirmPassword" name="confirmPassword" type="password" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter your password">
                </label>

                <button class="w-full py-3 font-medium text-white bg-indigo-600 hover:bg-indigo-500 rounded-lg border-indigo-500 hover:shadow inline-flex space-x-2 items-center justify-center">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1" />
                    </svg>
                    <span>Login</span>
                </button>

            </div>
        </form>
    </div>

    </body>




</div>
</body>
</html>