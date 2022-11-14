<%@ page import="metier.entity.UsersEntity" %>
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
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
    <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>







<div class="container col-md-8 col-md-offset-3" style="overflow: auto">

    <div class="flex flex-row">


        <div>

            <body class="font-poppins antialiased">
            <div id="view" class="h-full flex flex-row" x-data="{ sidenav: true }">
                <button @click="sidenav = true"
                        class="p-2 border-2 bg-white rounded-md border-gray-200 shadow-lg text-gray-500 focus:bg-blue-500 focus:outline-none focus:text-white absolute top-0 left-0 sm:hidden">
                    <svg class="w-5 h-5 fill-current" fill="currentColor"
                         viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                              clip-rule="evenodd"></path>
                    </svg>
                </button>
                <div id="sidebar"
                     class="bg-white h-screen md:block shadow-xl px-3 w-30 md:w-60 lg:w-60 overflow-x-hidden transition-transform duration-300 ease-in-out"
                     x-show="sidenav" @click.away="sidenav = false">
                    <div class="space-y-6 md:space-y-10 mt-10">
                        <h1 class="font-bold text-4xl text-center md:hidden">
                            D<span class="text-blue-600">.</span>
                        </h1>
                        <h1
                                class="hidden md:block font-bold text-sm md:text-xl text-center">
                            Marjane<span class="text-blue-600">.</span>
                        </h1>

                        <div id="menu" class="flex flex-col space-y-2">
                            <div
                                    class=" flex text-sm font-medium text-gray-700 py-2 px-2 hover:bg-blue-500 hover:text-white hover:scale-105 rounded-md transition duration-150 ease-in-out">
                                <svg aria-hidden="true" class="flex-shrink-0 mr-3 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z" clip-rule="evenodd"></path></svg>
                                <a href="${pageContext.request.contextPath}/Profile"
                                   class="">Profile</a>
                            </div>

                            <div
                                    class=" flex text-sm font-medium text-gray-700 py-2 px-2 hover:bg-blue-500 hover:text-white hover:scale-105 rounded-md transition duration-150 ease-in-out">
                                <svg aria-hidden="true" class="flex-shrink-0 mr-3 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z" clip-rule="evenodd"></path></svg>
                                <a href="${pageContext.request.contextPath}/Login"
                                   class="">log out</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <script src="js/graph.js" type="text/javascript"></script>
            <script>
                var user = document.getElementById("user-chart").nodeName;
                var chart = new Graph({
                    data: [1, 20, 5, 6, 8],
                    target: document.querySelector(user),
                });
            </script>
            </body>


        </div>


        <body class="antialiased bg-slate-200 ">

        <div class="flex flex-col ">

            <form class="flex flex-row  mt-11" action="<%=request.getContextPath()%>/promotion/displayPromotion/filtered"
                  method="get">

    <div class="ml-3">
        <select name="status" class="bg-gray-50 p-11 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">

            <option value="pending">pending</option>
            <option value="accepted">accept</option>
            <option value="refused">refuse</option>
        </select>
    </div>
    <div  class="ml-1">
        <button class="ml-3 bg-gray-50 p-11 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" type="submit"> submit </button>

    </div>
            </form>

            <div class="  flex justify-center items-center flex-col mt-11 " >


             <div>

                <div class=" ml-3 w-4/5" style="overflow: scroll">


                <table class=" table-auto w-2/4	   "  >
                    <thead class="justify-between">
                    <tr class="bg-blue-600">

                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">Id</span>
                        </th>

                        <th class="px-16 py-2">

                            <span class="text-gray-100 font-semibold">Category</span>
                        </th>

                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">Subcategory</span>
                        </th>

                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">Percentage</span>
                        </th>
                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">start Date</span>
                        </th>
                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">End date</span>
                        </th>
                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">Status</span>
                        </th>
                        <th class="px-16 py-2">
                            <span class="text-gray-100 font-semibold">Action</span>
                        </th>
                    </tr>
                    </thead>
                    <tbody class="bg-gray-200">
                    <% try { List<PromoEntity> promotions = (ArrayList<PromoEntity>)
                            request.getAttribute("Promotions");

                        if (promotions == null) {
                            out.print("nothing to print");
                        } else {
                            System.out.println(promotions.get(0).getIdcategory()) ;
                    %>
                    <% for (PromoEntity s : promotions) { %>


                    <tr class="bg-white border-b-2 border-gray-200">

                        <td><span class="text-center ml-2 font-semibold">
                         <%= s.getIdpromo() %></span></td><td class="px-16 py-2"><span> <%= s.getCategoryByIdcategory().getName() %></span></td>

                        <td class="px-16 py-2"><span><%= s.getSubcategoryByIdsubcategory().getName() %></span></td>

                        <td class="px-16 py-2"><span><%= s.getPercentage() %></span></td>

                        <td class="px-16 py-2"><span><%= s.getStartdate() %></span></td>

                        <td class="px-16 py-2"><span><%= s.getEnddate() %></span></td>
                        <td class="px-16 py-2"><span><%= s.getStatus() %></span></td>

                        <td class="px-16 py-2">
                            <a onclick="return confirm('are you sure?')"
                               href="<%=request.getContextPath()%>/promotion/updatePromotion?status=refused&idPromo=<%=s.getIdpromo() %> ">
                                Refuse ------- </a>
                            <a onclick="return confirm('are you sure?')"
                               href="<%=request.getContextPath()%>/promotion/updatePromotion?status=accepted&idPromo=<%=s.getIdpromo() %>">
                                Accept </a>
                        </td>


                    </tr>
                    <% } } } catch (Exception e) { e.getStackTrace(); } %>

                    </tbody>
                </table>
                </div>

</div>
            </div>
        </div>


        </body>

    </div>



</div>
</body>

</html>