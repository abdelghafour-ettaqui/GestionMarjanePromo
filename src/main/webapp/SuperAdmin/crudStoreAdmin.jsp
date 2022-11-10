<%@ page import="metier.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.entity.StoreEntity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
    <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</head>
<body>







<div class="container col-md-8 col-md-offset-3" style="overflow: auto">

    <div class="flex flex-row">
        <div>
            <!-- component -->
            <body class="font-poppins antialiased">
            <div
                    id="view"
                    class="h-full flex flex-row"
                    x-data="{ sidenav: true }"
            >
                <button
                        @click="sidenav = true"
                        class="p-2 border-2 bg-white rounded-md border-gray-200 shadow-lg text-gray-500 focus:bg-teal-500 focus:outline-none focus:text-white absolute top-0 left-0 sm:hidden"
                >
                    <svg
                            class="w-5 h-5 fill-current"
                            fill="currentColor"
                            viewBox="0 0 20 20"
                            xmlns="http://www.w3.org/2000/svg"
                    >
                        <path
                                fill-rule="evenodd"
                                d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                                clip-rule="evenodd"
                        ></path>
                    </svg>
                </button>
                <div
                        id="sidebar"
                        class="bg-white h-screen md:block shadow-xl px-3 w-30 md:w-60 lg:w-60 overflow-x-hidden transition-transform duration-300 ease-in-out"
                        x-show="sidenav"
                        @click.away="sidenav = false"
                >
                    <div class="space-y-6 md:space-y-10 mt-10">
                        <h1 class="font-bold text-4xl text-center md:hidden">
                            D<span class="text-teal-600">.</span>
                        </h1>
                        <h1 class="hidden md:block font-bold text-sm md:text-xl text-center">
                            Marjane<span class="text-teal-600">.</span>
                        </h1>

                        <div id="menu" class="flex flex-col space-y-2">
                            <div

                                    class="text-sm font-medium text-gray-700 py-2 px-2 hover:bg-teal-500 hover:text-white hover:text-base rounded-md transition duration-150 ease-in-out"
                            >
                                <svg
                                        class="w-6 h-6 fill-current inline-block"
                                        fill="currentColor"
                                        viewBox="0 0 20 20"
                                        xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                            d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"
                                    ></path>
                                </svg>
                                <button type="button" data-modal-toggle="defaultModal">
                                    Add store admin
                                </button>
                            </div>

                            <div

                                    class="text-sm font-medium text-gray-700 py-2 px-2 hover:bg-teal-500 hover:text-white hover:scale-105 rounded-md transition duration-150 ease-in-out"
                            >
                                <svg
                                        class="w-6 h-6 fill-current inline-block"
                                        fill="currentColor"
                                        viewBox="0 0 20 20"
                                        xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                            d="M13 6a3 3 0 11-6 0 3 3 0 016 0zM18 8a2 2 0 11-4 0 2 2 0 014 0zM14 15a4 4 0 00-8 0v3h8v-3zM6 8a2 2 0 11-4 0 2 2 0 014 0zM16 18v-3a5.972 5.972 0 00-.75-2.906A3.005 3.005 0 0119 15v3h-3zM4.75 12.094A5.973 5.973 0 004 15v3H1v-3a3 3 0 013.75-2.906z"
                                    ></path>
                                </svg>
                                <span class="">log out</span>
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


        <body class="antialiased bg-slate-200">



    <!-- Main modal -->
    <div id="defaultModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
        <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
            <!-- Modal content -->
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                <!-- Modal header -->
                <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
                    <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
                        Add store admin
                    </h3>
                    <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-toggle="defaultModal">
                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                        <span class="sr-only">Close modal</span>
                    </button>
                </div>
                <!-- Modal body -->
                <div class="p-6 space-y-6">

                    <form action="${pageContext.request.contextPath}/crudStoreAdmin/addStoreAdmin" method="post" >
                        <div class="relative z-0 mb-6 w-full group">
                            <input type="text" name="fullname" id="fullname" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required="">
                            <label for="fullname" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Fullname</label>
                        </div>
                        <div class="relative z-0 mb-6 w-full group">
                            <input type="text" name="email" id="email" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required="">
                            <label for="email" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Email</label>
                        </div>
                        <div class="relative z-0 mb-6 w-full group">
                            <label for="idStore" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Store id</label>
                            <select id="idStore" required class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" name="idStore">
                            <%
                            try {
                                List<StoreEntity> stores = (ArrayList<StoreEntity>) request.getAttribute("stores");
                                if(stores==null){
                                    out.print("nothing to print");
                                }else{
                                    for(StoreEntity s:stores){ %>

                                <option value="<%=  s.getIdstore() %>"><%=  s.getCity() %> </option>
                                <%   }
                                }
                                }catch (Exception e) {
                                    e.getStackTrace();
                                }

                                %>
                            </select>


                        </div>
                        <div class="grid md:grid-cols-2 md:gap-6">
                            <div class="relative z-0 mb-6 w-full group">
                                <input type="password" name="password" id="password" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required="">
                                <label for="password" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Password</label>
                            </div>
                        </div>
                        <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200 dark:border-gray-600">
                            <button  type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" data-modal-toggle="edit" >Submit</button>

                        </div>
                    </form>

                </div>
                <!-- Modal footer -->

            </div>
        </div>
      </div>



    <div>
    </div>











    <!-- Main modal -->
    <div id="edit" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
        <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
            <!-- Modal content -->
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                <!-- Modal header -->
                <div class="flex justify-between items-start p-4 rounded-t border-b dark:border-gray-600">
                    <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
                        edit store admin
                    </h3>
                    <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-toggle="edit">
                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                        <span class="sr-only">Close modal</span>
                    </button>
                </div>
                <!-- Modal body -->
                <div class="p-6 space-y-6">

                    <form action="${pageContext.request.contextPath}/crudStoreAdmin/updateStoreAdmin" method="post" >
                        <div class="relative z-0 mb-6 w-full group">
                            <input type="text" name="fullname" id="fullnameE" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required="">
                            <label for="fullnameE" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Fullname</label>
                        </div>
                        <div class="relative z-0 mb-6 w-full group">
                            <input type="text" name="email" id="emailE" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required="">
                            <label for="emailE" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Email</label>
                        </div>
                        <div class="relative z-0 mb-6 w-full group">
                            <label for="idStore" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Store id</label>
                            <select id="idStore" required class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" name="idStore">
                                <%
                                    try {
                                        List<StoreEntity> stores = (ArrayList<StoreEntity>) request.getAttribute("stores");
                                        if(stores==null){
                                            out.print("nothing to print");
                                        }else{
                                            for(StoreEntity s:stores){ %>

                                <option value="<%=  s.getIdstore() %>"><%=  s.getCity() %> </option>
                                <%   }
                                }
                                }catch (Exception e) {
                                    e.getStackTrace();
                                }

                                %>
                            </select>


                        </div>
                        <div class="grid md:grid-cols-2 md:gap-6">
                            <div class="relative z-0 mb-6 w-full group">
                                <input type="password" name="password" id="passwordE" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required="">
                                <input type="hidden" name="idStoreAdmin" id="selectedRow" >
                                <label for="passwordE" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Password</label>
                            </div>
                        </div>
                        <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200 dark:border-gray-600">
                            <button  type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" >Submit</button>

                        </div>
                    </form>

                </div>
                <!-- Modal footer -->

            </div>
        </div>
    </div>



    <div>
    </div>










    <div class="mt-10">
        <table class="max-w-5xl mx-auto table-auto">
            <thead class="justify-between">
            <tr class="bg-blue-600">
                <th class="px-16 py-2">
                    <span class="text-gray-100 font-semibold">Avatar</span>
                </th>
                <th class="px-16 py-2">
                    <span class="text-gray-100 font-semibold">Id</span>
                </th>

                <th class="px-16 py-2">

                    <span class="text-gray-100 font-semibold">Fullname</span>
                </th>

                <th class="px-16 py-2">
                    <span class="text-gray-100 font-semibold">Email</span>
                </th>

                <th class="px-16 py-2">
                    <span class="text-gray-100 font-semibold">Edit</span>
                </th>
                <th class="px-16 py-2">
                    <span class="text-gray-100 font-semibold">Delete</span>
                </th>
            </tr>
            </thead>
            <tbody class="bg-gray-200">
            <%
                try{
                    List<UsersEntity> storeAdmin = (ArrayList<UsersEntity>) request.getAttribute("storeAdmins");

                        if(storeAdmin==null){
                            out.print("nothing to print");
                        }else{
                            for(UsersEntity s:storeAdmin){ %>



            <tr class="bg-white border-b-2 border-gray-200">
                <td class="px-16 py-2 flex flex-row items-center">
                    <img class="h-8 w-8 rounded-full object-cover " src="https://randomuser.me/api/portraits/men/30.jpg" alt=""/>
                </td>
                <td><span class="text-center ml-2 font-semibold"> <%=  s.getIduser()  %>   </span></td>

                <td class="px-16 py-2"><span> <%=  s.getFullname()  %>  </span> </td>

                <td class="px-16 py-2"><span> <%=  s.getEmail()  %>  </span></td>

                <td class="px-16 py-2">
                    <button type="button" class="idStoreAdmin" data-modal-toggle="edit" data-id="<%= s.getIduser() %>"  ><span > edit </span> </button>

                </td>
                <td class="px-16 py-2">
                    <a onclick="return confirm('are you sure?')" href="<%=request.getContextPath()%>/crudStoreAdmin/delete?id=<%= s.getIduser() %>">Delete</a>

                </td>

            </tr>

         <%   }
            }
            }catch (Exception e) {
             e.getStackTrace();
         }

            %>

            </tbody>
        </table>
    </div>
    <script type="text/javascript">
        const id = document.querySelectorAll(".idStoreAdmin");
        let selectedRow = document.getElementById('selectedRow');
        id.forEach((idStoreAdmin) => {
            idStoreAdmin.addEventListener("click", (e) => {
                selectedRow.value=idStoreAdmin.dataset.id;
                console.log(selectedRow.value)
            })
        });


    </script>

    </body>

    </div>

</div>
</body>
</html>