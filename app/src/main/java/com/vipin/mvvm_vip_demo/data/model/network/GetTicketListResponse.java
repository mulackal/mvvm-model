
package com.vipin.mvvm_vip_demo.data.model.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTicketListResponse {

        @SerializedName("model")
        @Expose
        private GetOpenTicketsResponseModel model;
        @SerializedName("totalResults")
        @Expose
        private Integer totalResults;
        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("message")
        @Expose
        private String message;

        public GetOpenTicketsResponseModel getModel() {
            return model;
        }

        public void setModel(GetOpenTicketsResponseModel model) {
            this.model = model;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

}
