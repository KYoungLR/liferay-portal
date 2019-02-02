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