<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key=" lang.dir" />" lang="${w3c_language_id}">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta content="initial-scale=1.0, width=device-width" name="viewport" />

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Airbnb App Template - Kevin Young</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/icon" href="/o/kyoung-liferay-theme/images/favicon.ico" />
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <!-- Open Sans for body and title font -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700,800" rel="stylesheet">
    <!--  pt animation js   -->
    <script src="/o/kyoung-liferay-theme/js/pt.min.js"></script>

    <@liferay_util["include"] page=top_head_include />


</head>

<body class="${css_class}">

    <@liferay_ui["quick-access"] contentId="#main-content" />

    <@liferay_util["include"] page=body_top_include />

    <@liferay.control_menu />
    <!-- Start Header -->
    <#if show_header>
        <header role="banner">
            <div id="home" class="flex height-fix">
                <div id="pt" class="canvas"></div>
                <div class="flex">
                    <!-- Start Logo -->
                    <div class="mu-logo-area">
                        <a class="mu-logo" href="#"><img src="${site_logo}" alt="logo img ${logo_description}"></a>
                    </div>
                    <#assign preferences=freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId":
                        "barebone" , "destination" : "/search" }) />
                </div>
                <!-- End Logo -->
            </div>
            </div>
        </header>

        <!-- End Header -->
        <!-- Start Menu -->
        <button class="mu-menu-btn">
            <i class="fa fa-bars"></i>
        </button>
        <div class="mu-menu-full-overlay">
            <div class="mu-menu-full-overlay-inner">
			    <a class="mu-menu-close-btn"></a>

                <#--  <a class="mu-menu-close-btn" href="#"><span class="mu-line"></span></a>  -->
                <nav class="mu-menu" role="navigation">
                    <ul>
						<li>
							<#if show_site_name>
								<div class="company-name">Welcome To ${site_name}</div>
							</#if>
						</li>
						<li>
							<div id="center" class="user-personal-bar">
								<@liferay.user_personal_bar />
							</div>
						</li>
						<li>
							<div id="center">
								<#include "${full_templates_path}/navigation.ftl" />
							</div>
						</li>
						<!--  Search Bar  -->
						<#if show_header_search>
							<li>
								<div id="center">
									<div class="navbar-form" role="search">
										<@liferay.search_bar default_preferences="${preferences}" />
									</div>
								</div>
							</li>
						</#if>
					</ul>
				</nav>

            </div>
        </div>
        </div>
        <!-- End Menu -->
        </header>
    </#if>
    <div class="main-container">
        <section class="${portal_content_css_class}" id="content">
            <h1 class="sr-only">${the_title}</h1>

            <#if selectable>
                <@liferay_util["include"] page=content_include />
                <#else>
                    ${portletDisplay.recycle()}

                    ${portletDisplay.setTitle(the_title)}

                    <@liferay_theme["wrap-portlet"] page="portlet.ftl">
                        <@liferay_util["include"] page=content_include />
                        </@>
            </#if>
        </section>
    </div>

    <!-- Start footer -->
    <#if show_footer>
        <footer id="mu-footer" role="contentinfo">
            <div class="container">
                <div class="mu-footer-area">
                        <@liferay.language key="powered-by" />
                        <a href="http://www.liferay.com" rel="external">Liferay</a>
                </div>
            </div>
        </footer>
    </#if>
    </div>

    <!-- End footer -->



    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Custom js -->
    <script type="text/javascript" src="/o/kyoung-liferay-theme/js/custom.js"></script>

    <!-- Header Canvas -->
    <script src="/o/kyoung-liferay-theme/js/canvas.js"></script>

    <@liferay_util["include"] page=body_bottom_include />

    <@liferay_util["include"] page=bottom_include />

</body>

</html>