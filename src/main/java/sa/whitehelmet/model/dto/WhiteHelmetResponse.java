package sa.whitehelmet.model.dto;



import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Representing the main response of the application
 * @author abdallahsameer22@gmail.com
 * @since 2025-01-25
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WhiteHelmetResponse <T>{
    private final T data;
    private final Long offset;
    private final Long limit;
    private final Long totalCount;
    private final String moreDetails;
    public WhiteHelmetResponse(Builder<T> builder) {
        this.data = builder.data;
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.totalCount = builder.totalCount;
        this.moreDetails = builder.moreDetails;
    }

    public static class Builder<T>{
        private T data;
        private Long offset;
        private Long limit;
        private Long totalCount;
        private String moreDetails;

        public Builder<T> offset(Long offset) {
            this.offset = offset;
            return this;
        }
        public Builder<T> limit(Long limit) {
            this.limit = limit;
            return this;
        }
        public Builder<T> totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }
        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> moreDetails(String moreDetails) {
            this.moreDetails = moreDetails;
            return this;
        }
        public WhiteHelmetResponse<T> build(){
            return new WhiteHelmetResponse<>(this);
        }
    }

    public T getData() {
        return data;
    }

    public Long getOffset() {
        return offset;
    }

    public Long getLimit() {
        return limit;
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public String getMoreDetails() {
        return moreDetails;
    }
    @Override
    public String toString() {
        return "LibraryMSResponse{" +
                "data=" + data +
                ", offset=" + offset +
                ", limit=" + limit +
                ", totalCount=" + totalCount +
                ", moreDetails='" + moreDetails + '\'' +
                '}';
    }
}
