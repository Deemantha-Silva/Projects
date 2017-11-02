<%-- 
    Document   : InputPyramid
    Created on : Oct 3, 2017, 9:32:36 PM
    Author     : Deemantha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
            <title>Pyramid Builder</title>
        </head>
        <body>
            <div class="jumbotron text-center">
                <h1>${greeting}</h1>
                <h2>Input Pyramid</h2>
            </div>
            <form method="post" action="InsertPyramid.do">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-4">
                            <p>
                                <label for="pyramidB">Number of Sides (3-20):</label>
                                <input type="text" id="pyramidB" name="baseN"
                                       value="<c:out value="${pDataCookies.baseN}"/>">
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <p>
                                <label for="pyramidS">Side Length (meters):</label>
                                <input type="text" id="pyramidS" name="baseSide" 
                                       value="<c:out value="${pDataCookies.baseSide}"/>">
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <p>
                                <label for="pyramidH">Height (meters):</label>
                                <input type="text" id="pyramidH" name="height" 
                                       value="<c:out value="${pDataCookies.height}"/>">
                            </p>
                        </div>
                    </div>
                </div>
                <div class="container-fluid" style="position: relative; top: 40%;">
                    <div class="row">
                        <div class="col-sm-12">
                            <input type="submit" class="btn btn-primary btn-block" value="Send"/>

                        </div>
                    </div>
                </div>
            </form>
            <hr>
            <div class="container-fluid">
                <div class="row" style="position: fixed; bottom: 3%; width: 100%;">
                    <div class="col-sm-4">
                    </div>
                    <div class="col-sm-4">
                    </div>
                    <div class="col-sm-4">
                        <footer>
                            <my:Date/>
                        </footer>
                    </div>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        </body>
    </html>
