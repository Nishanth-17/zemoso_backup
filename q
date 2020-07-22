  <c:url var="cart" value="/list">
                  <c:param name="username" value="${pageContext.request.userPrincipal.name}"/>
            </c:url>





$2a$10$piBfqQguR9zrhIBbKjkJH.RphvTKu0dg.yRw/0fJXf9MyMJbNLLyW
$2a$10$piBfqQguR9zrhIBbKjkJH.RphvTKu0dg.yRw/0fJXf9MyMJbNLLyW
$2a$10$u8UjqlCKuoUbddqmXmxt6.6tshDVHyq1IaDJ4/69HTJcenoJOvxyy



        <input type="password" th:field="*{password}"
               class="form-control mb-4 col-4" placeholder="Password">
        <p style="color:red" th:if="${#fields.hasErrors('password')}" th:errors="*{password}">Mobile Error</p>

        <input type="password" th:field="*{passwordConfirm}"
               class="form-control mb-4 col-4" placeholder="Confirm Your Password">
        <p style="color:red" th:if="${#fields.hasErrors('passwordConfirm')}" th:errors="*{passwordConfirm}">Mobile Error</p>
