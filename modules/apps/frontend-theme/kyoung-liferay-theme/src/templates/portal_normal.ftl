<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key=" lang.dir" />" lang="${w3c_language_id}">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta content="initial-scale=1.0, width=device-width" name="viewport" />
    <#--  font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <#--  pt animation js for header -->
    <script src="/o/kyoung-liferay-theme/js/pt.min.js"></script>

    <#-- Slick slider -->
    <link href="/o/kyoung-liferay-theme/css/slick/slick.css" rel="stylesheet">
    
    <#--  Alloy UI  -->
    <script src="https://cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>
    <link href="https://cdn.alloyui.com/3.0.1/aui-css/css/bootstrap.min.css" rel="stylesheet">


    <@liferay_util["include"] page=top_head_include />

</head>

<body class="${css_class}">

    <@liferay_ui["quick-access"] contentId="#main-content" />

    <@liferay_util["include"] page=body_top_include />

    <@liferay.control_menu />

    <#-- Start Header -->
    <#if show_header>
        <header role="banner">
            <div class="flex height-fix home">
                <div class="canvas" id="pt" ></div>
				        <#-- Start Logo -->
                <div class="flex">
                    <div class="logo-wrapper">
                        <a class="logo-container" alt="logo"><img class="logo" alt="${logo_description}" src="${site_logo}" /></a>
                    </div>

                    <#assign 
                            preferences = freeMarkerPortletPreferences.getPreferences(
                                    {
                                            "portletSetupPortletDecoratorId": "barebone" , 
                                            "destination" : "/search" 
                                            }
                            )
                    />

                </div>
                        <#-- End Logo -->
            </div>
        </header>
    <#-- End Header Content -->

        <#-- Start Menu -->
        <button class="menu-btn"></button>
        <div class="menu-full-overlay">
            <div class="menu-full-overlay-inner">
				<a class="menu-close-btn"></a>
                <nav class="menu-nav" role="navigation">
                    <ul>
                        <#if show_site_name>
                            <li>
                                <div class="company-name">
                                    <@liferay.language key="WELCOME TO" />
                                    ${site_name}</div>
                            </li>
                        </#if>

						<li>
							<div class="user-personal-bar">
								<@liferay.user_personal_bar />
							</div>
						</li>
						<li>
							<div>
								<#include "${full_templates_path}/navigation.ftl" />
							</div>
						</li>
						<#--  Search Bar  -->
						<#if show_header_search>
							<li>
								<div class="search-container">
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
        <#-- End Menu -->
        </header>
    </#if>

	<#--  Main Content  -->
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


<!-- Start Apps Screenshot -->
		<section id="apps-screenshot">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="apps-screenshot-area">

							<div class="title-area">
								<h2 class="title">APPS SCREENSHOT</h2>
								<span class="title-dot"></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis unde, ut sapiente et voluptatum facilis consectetur incidunt provident asperiores at necessitatibus nulla sequi voluptas libero quasi explicabo veritatis minima porro.</p>
							</div>


							<!-- Start Apps Screenshot Content -->
							<div class="apps-screenshot-content">

								<div class="apps-screenshot-slider">

									<div class="single-screeshot">
										<img src="/o/kyoung-liferay-theme/images/screenshot/01.jpg" alt="App screenshot img">
									</div>

									<div class="single-screeshot">
										<img src="/o/kyoung-liferay-theme/images/screenshot/01.jpg" alt="App screenshot img">
									</div>

									<div class="single-screeshot">
										<img src="/o/kyoung-liferay-theme/images/screenshot/01.jpg" alt="App screenshot img">
									</div>

									<div class="single-screeshot">
										<img src="/o/kyoung-liferay-theme/images/screenshot/01.jpg" alt="App screenshot img">
									</div>

									<div class="single-screeshot">
										<img src="/o/kyoung-liferay-theme/images/screenshot/01.jpg" alt="App screenshot img">
									</div>

									<div class="single-screeshot">
										<img src="/o/kyoung-liferay-theme/images/screenshot/01.jpg" alt="App screenshot img">
									</div>

						

								</div>

							</div>
							<!-- End Apps Screenshot Content -->

						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Apps Screenshot -->

    <#-- Start footer -->
    <#if show_footer>
        <footer id="footer" role="contentinfo">
            <div class="container">
                <div class="footer-area">
                        <@liferay.language key="powered-by" />

                        <a href="http://www.liferay.com" rel="external">Liferay &copy;</a>
                </div>
            </div>
        </footer>
    </#if>
    </div>
    <#-- End footer -->

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <#-- Header Canvas -->
    <script src="/o/kyoung-liferay-theme/js/canvas.js" type="text/javascript"></script>

 <!-- Bootstrap -->
    <script src="/o/kyoung-liferay-theme/js/bootstrap.min.js"></script>

    <#-- Slick slider -->
    <script src="/o/kyoung-liferay-theme/js/slick.min.js" type="text/javascript"></script>

    <#-- Slick slider js -->
    <script src="/o/kyoung-liferay-theme/js/main.js" type="text/javascript"></script>

    
   

    <@liferay_util["include"] page=body_bottom_include />

    <@liferay_util["include"] page=bottom_include />

</body>

</html>

