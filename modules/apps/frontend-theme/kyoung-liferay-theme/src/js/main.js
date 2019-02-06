AUI().ready(
	'liferay-sign-in-modal',
	function(A) {
		var signIn = A.one('.sign-in > a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}
);

(function($) {

    $('.menu-btn').on(
            'click',
            function(event) {
                    event.preventDefault();

                    $('.menu-full-overlay').addClass('menu-full-overlay-show');
            }
    );

    $('.menu-close-btn').on(
            'click',
            function(event) {
                    event.preventDefault();

                    $('.menu-full-overlay').removeClass('menu-full-overlay-show');
            }
    );

    $('.menu-nav a').on(
            'click',
            function(event) {

                    $('.menu-full-overlay').removeClass('menu-full-overlay-show');
            }
    );

})(jQuery);


// Alloy Carousel
YUI().use(
	'aui-carousel',
	function(Y) {
	  new Y.Carousel(
		{
		  contentBox: '#myCarousel',
		  height: 600,
		  width: 300,
		  left: '38%'
		}
	  ).render();
	}
  );




/* ----------------------------------------------------------- */
	/*  3. VIDEO POPUP
	/* ----------------------------------------------------------- */

	$('.video-play-btn').on('click', function(event) {
	   
        event.preventDefault();
        
        $('.video-iframe-area').addClass('video-iframe-display');
       
    });
   
    // when click the close btn

    // disappear iframe window
    
    $('.video-close-btn').on('click', function(event) {
	    
	    event.preventDefault();
	    
		$('.video-iframe-area').removeClass('video-iframe-display');
		
    });

    // stop iframe if it is play while close the iframe window

    $('.video-close-btn').click(function(){

        $('.video-iframe').attr('src', $('.video-iframe').attr('src'));

    });

    // when click overlay area

     $('.video-iframe-area').on('click', function(event) {
	    
	    event.preventDefault();
	    
		$('.video-iframe-area').removeClass('video-iframe-display');
		
    });

	$('.video-iframe-area, .video-iframe').on('click', function(e){
	    e.stopPropagation();
	});


