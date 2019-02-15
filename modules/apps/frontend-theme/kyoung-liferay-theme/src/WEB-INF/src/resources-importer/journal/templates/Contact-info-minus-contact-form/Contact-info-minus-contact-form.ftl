<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="contact-area contact-form-logo-area">

                    <div class="contact-content-liferay">
                        <div class="row">

                            <div class="col-md-7">
                                <div class="contact-left">
                                    <div class="contact-right-single">
                                        <div class="icon"><span class="fa fa-map-marker"></span></div>
                                        <p><strong>Office Location</strong></p>
                                        <p>${OfficeLocation.getData()}</p>
                                    </div>

                                    <div class="contact-right-single">
                                        <div class="icon"><span class="fa fa-phone"></span></div>
                                        <p><strong>Phone Number</strong></p>
                                        <#if PhoneNumber.getSiblings()?has_content>
                                            <#list PhoneNumber.getSiblings() as cur_PhoneNumber>
                                                <p>${cur_PhoneNumber.getData()}</p>
                                            </#list>
                                        </#if>
                                    </div>

                                    <div class="contact-right-single">
                                        <div class="icon"><span class="fa fa-envelope"></span></div>
                                        <p><strong>Email Address</strong></p>
                                        <#if EmailAddress.getSiblings()?has_content>
                                            <#list EmailAddress.getSiblings() as cur_EmailAddress>
                                                <p>${cur_EmailAddress.getData()}</p>
                                            </#list>
                                        </#if>
                                    </div>

                                    <div class="contact-right-single">
                                        <div class="social-media">
                                            <#if SocialMediaLogo.getSiblings()?has_content>
                                                <#list SocialMediaLogo.getSiblings() as cur_SocialMediaLogo> <a href="${cur_SocialMediaLogo.SocialMediaURL.getData()}"><span class="fa ${cur_SocialMediaLogo.getData()}"></span></a> </#list>
                                            </#if>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>