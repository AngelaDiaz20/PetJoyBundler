<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
        crossorigin="anonymous">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/style.css">
    <title>PetJoy Shop</title>
</head>

<body id="body-dashboard">

    <%@ include file="./layouts/aside_client.jsp" %>

    <!-- <%@ include file="./layouts/navbar.jsp"%> -->

        <div class="container-all dash-add">
            <div class="container mt-4 mb-4 col-9">
                <h2 class="ml-green mb-4">Editar datos del cliente</h2>
                <form:form action="/dash/edit" modelAttribute="client" method="post" class="mt-4">

                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="nombre" class="form-label">Nombre</label></small>
                            <form:input type="text" path="nombre" cssClass="form-control"  />
                            <form:errors path="nombre" cssClass="error" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="apellido" class="form-label">Apellido</label></small>
                            <form:input type="text" path="apellido" cssClass="form-control"  />
                            <form:errors path="apellido" cssClass="error" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="nro_identificacion" class="form-label">Número de
                                    identificacion</label></small>
                            <form:input type="text" path="nro_identificacion" cssClass="form-control"/>
                            <form:errors path="nro_identificacion" cssClass="error" />
                        </div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="contrasena" class="form-label">Contraseña</label></small>
                            <form:input type="password" path="contrasena" cssClass="form-control" />
                            <form:errors path="contrasena" cssClass="error" />
                        </div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="email" class="form-label">Email</label></small>
                            <form:input type="email" path="email" cssClass="form-control"  />
                            <form:errors path="email" cssClass="error" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="celular" class="form-label">Celular</label></small>
                            <form:input type="number" path="celular" cssClass="form-control" />
                            <form:errors path="celular" cssClass="error" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="ciudad" class="form-label">Ciudad</label></small>
                            <form:input type="text" path="ciudad" cssClass="form-control" />
                            <form:errors path="ciudad" cssClass="error" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="departamento" class="form-label">Departamento</label></small>
                            <form:input type="text" path="departamento" cssClass="form-control" />
                            <form:errors path="departamento" cssClass="error" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="my-3 col-7">
                            <small><label for="direccion" class="form-label">Dirección</label></small>
                            <form:input type="text" path="direccion" cssClass="form-control" />
                            <form:errors path="direccion" cssClass="error" />
                        </div>
                    </div>
                    <br>
                    <div class="mt-4 d-flex justify-content-end">
                        <a href="/" type="button" class="btn btn-dark me-4">Cancelar</a>
                        <button type="submit" class="btn btn-success">Actualizar información</button>
                    </div>
                </form:form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
            </script>

</body>

</html>