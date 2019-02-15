<section id="apps-screenshot">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="apps-screenshot-area">

                    <div class="title-area">
                        <h2 class="title">APPS SCREENSHOT</h2>
                        <span class="title-dot"></span>
                        <p>${CarouselSummary.getData()}</p>
                    </div>

                    <div id="myCarousel">
                        <#if AppScreenshot.getSiblings()?has_content>
                            <#list AppScreenshot.getSiblings() as cur_AppScreenshot>
                                <#if cur_AppScreenshot.getData()?? && cur_AppScreenshot.getData() !="">
                                    <div class="image-viewer-base-image"><img alt="${cur_AppScreenshot.getAttribute(" alt ")}" data-fileentryid="${cur_AppScreenshot.getAttribute(" fileEntryId ")}" src="${cur_AppScreenshot.getData()}" /> </div>
                                </#if>
                            </#list>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>