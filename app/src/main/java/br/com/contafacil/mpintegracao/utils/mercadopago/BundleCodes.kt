package br.com.contafacil.mpintegracao.utils.mercadopago

interface BundleCodes {
    companion object {
        //To start the operation.
        /**
         * This is the amount to be charged, it must be a double.
         */
        const val AMOUNT = "amount"

        /**
         * This is the description to be seen at MercadoPago, it must be a String.
         */
        const val DESCRIPTION = "description"

        /**
         * Send this if you want to be notified that the buyer cancelled the payment in the middle.
         * The accepted values are true and false, the default is set to false
         */
        const val DISABLE_BACK_BUTTON = "disable_back_button"

        /**
         * Specify the card type must be one of
         * {@value Constants#CREDIT_CARD}, {@value Constants#DEBIT_CARD} or null.
         */
        const val CARD_TYPE = "card_type"

        /**
         * Specify the amount of installments must be an int
         */
        const val INSTALLMENTS = "installments"

        /**
         * Specify your MercadoPago's Application id. Can be null
         */
        const val APP_ID = "client_id"

        /**
         * Specify your MercadoPago's Application secret. Can be null
         */
        const val APP_SECRET = "client_secret"

        /**
         * Specify how much are you going to charge. This is NOT a percentage,
         * should be a number smaller than the value in AMOUNT. Can be null
         */
        const val APP_FEE = "application_fee"

        /**
         * Specify the sponsor_id to be used. If sent it can't be null
         */
        const val SPONSOR_ID = "sponsor_id"

        /**
         * Specify the notification_url to be used. If sent it can't be null
         */
        const val NOTIFICATION_URL = "notification_url"

        /**
         * Specifies the payer email to be pre loaded into the send email receipt view. If sent it can't be null
         */
        const val PAYER_EMAIL = "payer_email"

        /**
         * Specifies the collector email to be used. If sent it can't be null
         */
        const val COLLECTOR_ID = "collector_id"

        /**
         * Specify Kiosk mode. Which means the app will have less functionality to prevent access to the configuration.
         */
        const val IS_KIOSK = "is_kiosk"

        /**
         * Specifies the payer identification to be pre loaded into the identification view. If sent it can't be null. This
         * parameter is only needed for Argentina
         */
        const val IDENTIFICATION = "identification"

        /**
         * Specify the external_reference to be used. If sent it can't be null
         */
        const val EXTERNAL_REFERENCE = "external_reference"
        //For the return of the operation.
        /**
         * In case you are coming from URL based integration,
         * this are the URL's the app will call to end the flow.
         */
        const val URL_SUCCESS = "success_url"
        const val URL_FAIL = "fail_url"

        /**
         * Specifies the result of the operation can be
         * {@value Constants#RESULT_STATUS_FAILED} or {@value Constants#RESULT_STATUS_OK}
         */
        const val RESULT_STATUS = "result_status"

        /**
         * This only comes when the payment is approved, this is the replacement for
         * {@value Constants#RESULT_PAYMENT_ID}
         */
        const val PAYMENT_ID = "payment_id"

        /**
         * Specifies the trunc name of the person being charged
         */
        const val TRUNC_CARD_HOLDER = "trunc_card_holder"

        /**
         * This two only comes when the payment is rejected.
         */
        const val ERROR = "error"
        const val ERROR_DETAIL = "error_detail"

        /**
         * This is for the status receiver
         */
        const val STATUS = "STATUS"
    }
}