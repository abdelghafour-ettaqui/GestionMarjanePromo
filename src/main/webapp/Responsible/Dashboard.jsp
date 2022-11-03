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
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
    <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</head>
<body>

<div class="container col-md-8 col-md-offset-3" style="overflow: auto">

    <body class="antialiased bg-slate-200">

    <div class="mt-2">
        <table class="max-w-5xl mx-auto table-auto">
            <thead class="justify-between">
            <tr class="bg-green-600">

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
            <%
                    try{
                        List<PromoEntity> promotions = (ArrayList<PromoEntity>) request.getAttribute("Promotions");

                        if(promotions==null){
                            out.print("nothing to print");
                        }else{


                            for(PromoEntity s:promotions){   %>


            <tr class="bg-white border-b-2 border-gray-200">

                <td><span class="text-center ml-2 font-semibold"> <%= s.getIdpromo()   %>   </span></td>
                <td class="px-16 py-2"><span> <%= s.getCategoryByIdcategory().getName() %>  </span></td>

                <td class="px-16 py-2"><span> <%= s.getSubcategoryByIdsubcategory().getName()  %>  </span> </td>

                <td class="px-16 py-2"><span> <%= s.getPercentage() %>  </span></td>

                <td class="px-16 py-2"><span> <%= s.getStartdate() %>  </span></td>

                <td class="px-16 py-2"><span> <%= s.getEnddate() %>  </span></td>
                <td class="px-16 py-2"><span> <%= s.getStatus() %>  </span></td>

                <td class="px-16 py-2">

                    <a onclick="return confirm('are you sure?')" href="<%=request.getContextPath()%>/promotion/updatePromotion?status=refuse&idPromo=<%=s.getIdpromo() %> "> Refuse ------- </a>
                    <a onclick="return confirm('are you sure?')" href="<%=request.getContextPath()%>/promotion/updatePromotion?status=accept&idPromo=<%=s.getIdpromo() %>"> Accept </a>
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



    </body>

</div>
</body>
</html>