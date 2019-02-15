<section id="download">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="download-area">

                    <div class="title-area">
                        <h2 class="title">GET THE APP</h2>
                        <span class="title-dot"></span>
                        <p>${GetTheAppSummary.getData()}</p>
                    </div>

                    <div class="download-content">
                        <#if GetTheAppButtonText.getSiblings()?has_content>
                            <#list GetTheAppButtonText.getSiblings() as cur_GetTheAppButtonText>
                                <a class="social-btn" href="#">
                                    <span class="${cur_GetTheAppButtonText.GetTheAppButtonLogo.getData()}"></span>
                                    <span>${cur_GetTheAppButtonText.getData()}</span>
                                </a>
                            </#list>
                        </#if>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>