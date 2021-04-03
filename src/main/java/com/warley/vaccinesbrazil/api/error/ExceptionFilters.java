package com.warley.vaccinesbrazil.api.error;

public class ExceptionFilters {

    private String title;
    private int status;
    private String details;
    private Long timeStamp;
    private String devMsg;

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public String getDevMsg() {
        return devMsg;
    }

    public static final class ExceptionFiltersBuilder {

        private String title;
        private int status;
        private String details;
        private Long timeStamp;
        private String devMsg;

        private ExceptionFiltersBuilder() {
        }

        public static ExceptionFiltersBuilder newBuilder() {
            return new ExceptionFiltersBuilder();
        }

        public ExceptionFiltersBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ExceptionFiltersBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ExceptionFiltersBuilder details(String details) {
            this.details = details;
            return this;
        }

        public ExceptionFiltersBuilder timeStamp(Long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public ExceptionFiltersBuilder devMsg(String devMsg) {
            this.devMsg = devMsg;
            return this;
        }

        public ExceptionFilters build() {
            ExceptionFilters exceptionFilters = new ExceptionFilters();
            exceptionFilters.title = this.title;
            exceptionFilters.status = this.status;
            exceptionFilters.details = this.details;
            exceptionFilters.timeStamp = this.timeStamp;
            exceptionFilters.devMsg = this.devMsg;
            return exceptionFilters;
        }

    }

}
