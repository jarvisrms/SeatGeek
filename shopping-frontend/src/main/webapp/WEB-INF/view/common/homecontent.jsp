 <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">

				<c:forEach items="${categories}" var="category">
					<a href="${contextRoot}/showByCategory/${category.id}/All" class="list-group-item" id="a_${category.name}"> ${category.name}</a>
				</c:forEach>


			</div>
            </div>

           <c:if test="${userClickHome==true}">
           <%@include  file="../home.jsp"%>
           </c:if>
           
           <c:if test ="${userClickAbout==true }">
           <%@include file="../about.jsp" %>
           </c:if>
           <c:if test="${userClickByCategory==true  or userAllProduct ==true}">
           <%@include file="../productviewpage.jsp" %>
           </c:if>
        </div>

