<%-- 
    Document   : ConfirmPyramid
    Created on : Oct 3, 2017, 9:32:36 PM
    Author     : Deemantha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                <h2>Pyramid Dimensions</h2>
            </div>
            <form method="post" action="InsertPyramid.do">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-4">
                            <p>
                                <label>Number of Sides of Base:</label>
                                <span style="color:#9933CC;">${Pyramid.baseN}</span>
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <p>
                                <label>Side Length (meters):</label>
                                <span style="color:#9933CC;">${Pyramid.baseSide}</span>
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <p>
                                <label>Height (meters):</label>
                                <span style="color:#9933CC;">${Pyramid.height}</span>
                            </p>
                        </div> 
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <p>
                                <label>Base Area (meters squared):</label>
                                <span style="color:#9933CC;"><fmt:formatNumber type ="number" pattern="#.###" value="${Pyramid.baseArea}"/></span>
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <p>
                                <label>Volume (meters cubed):</label>
                                <span style="color:#9933CC;"><fmt:formatNumber type ="number" pattern="#.###" value="${Pyramid.volume}" /></span>
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <p>
                                <label>The Pyramid You Made is a:</label>
                                <span style="color:#9933CC;">${Pyramid.pyramidName}</span>
                            </p>
                        </div>
                    </div>
                </div>
            </form>

            <hr>
            <div class="container-fluid">
                <div class="row" style="position: fixed; bottom: 3%; width: 100%;">
                    <div class="col-sm-4">
                        <a href="InputPyramid.do" class="btn btn-info" role="button">Back</a>
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
