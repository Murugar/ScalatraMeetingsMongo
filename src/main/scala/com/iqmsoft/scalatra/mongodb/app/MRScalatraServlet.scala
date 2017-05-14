package com.iqmsoft.scalatra.mongodb.app

import org.scalatra._

class MRScalatraServlet extends ScalatraMeetingRoomReservationStack {

  get("/") {
//    contentType="text/html"
//    ssp("/index", "title"->"")
    <html>
      <head>
        <meta charset="utf-8"/>
        <title>Meeting Room</title>

        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="/resources/lib/landingTemplate/vendor/bootstrap/css/bootstrap.min.css"/>

        <!-- Custom Fonts -->
        <link href="/resources/lib/landingTemplate/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic" rel="stylesheet" type="text/css"/>

        <!-- Theme CSS -->
        <link href="/resources/lib/landingTemplate/css/creative.css" rel="stylesheet"/>
      </head>

      <body>

        <script src="/resources/lib/landingTemplate/vendor/jquery/jquery.min.js"></script>
        <script src="/resources/lib/landingTemplate/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="/resources/custom/js/commonUtil.js"></script>

        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
              </button>
              <a class="navbar-brand page-scroll" href="#page-top">Meetings</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">
                <li>
                  <a class="page-scroll" href="#about">About</a>
                </li>
                <li>
                  <a class="page-scroll" href="#services">Contact</a>
                </li>
              </ul>
            </div>
            <!-- /.navbar-collapse -->
          </div>
          <!-- /.container-fluid -->
        </nav>

        <header>
          <div class="header-content">
            <div class="header-content-inner">
              <h1 id="homeHeading">Greetings</h1>
              <hr/>
              <p>Welcome to Meetings Calendar!</p>
              <a href="#" class="btn btn-primary btn-xl page-scroll" onclick="convertUrl('/main'); return false;">Appointment Calendar</a>
            </div>
          </div>
        </header>

      </body>

    </html>
  }

}
