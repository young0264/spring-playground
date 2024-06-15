package spring.playground.cloud.openFeign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String rsltCd;
    private String rsltMsg;
    private String rsltDetailMsg;
    private T data;

//    public static CommonResponse error(ErrorCodeI errCd) {
//
//        ErrorCode errorCode = errCd.getErrorCode();
//        return CommonResponse.builder()
//                .rsltCd(errorCode.getRsltCd())
//                .rsltMsg(errorCode.getRsltMsg())
////                .rsltMsg(errorCode.getRsltDetailMsg())
//                .rsltDetailMsg(errorCode.getRsltDetailMsg())
//                .build();
//    }

////    public static TpsResponse error(ErrorCode errCd) {
////
////        return TpsResponse.builder()
////                .rsltCd(errCd.getRsltCd())
////                .rsltMsg(errCd.getRsltMsg())
////                .build();
////    }
//
////    public static TpsResponse error(ErrorCode errCd, Object data) {
////
////        return TpsResponse.builder()
////                .rsltCd(errCd.getRsltCd())
////                .rsltMsg(errCd.getRsltMsg())
////                .data(data)
////                .build();
////    }
//
//    public static CommonResponse<?> success(Object data) {
//
//        ErrorCode errCd = ErrorCodeGeneral.SUCCESS.getErrorCode();
//        return CommonResponse.builder()
//                .rsltCd(errCd.getRsltCd())
//                .rsltMsg(errCd.getRsltMsg())
//                .rsltDetailMsg(errCd.getRsltDetailMsg())
//                .data(data)
//                .build();
//
//    }
//
//    /*
//     * 정상 응답 - 파리미터 없는 버전
//     */
//    public static CommonResponse<?> success() {
//        ErrorCode errCd = ErrorCodeGeneral.SUCCESS.getErrorCode();
//        return CommonResponse.builder()
//                .rsltCd(errCd.getRsltCd())
//                .rsltMsg(errCd.getRsltMsg())
//                .rsltDetailMsg(errCd.getRsltDetailMsg())
//                .data(null)
//                .build();
//    }
//
//    public static CommonResponse<?> validError(String errMsg) {
//        ErrorCode errCd = ErrorCodeGeneral.BAD_REQUEST.getErrorCode();
//
////        String rsltMsg = errCd.getRsltMsg();
////        StringUtils.isEmpty(rsltMsg)
//
//        return CommonResponse.builder()
//                .rsltCd(errCd.getRsltCd())
//                .rsltMsg(errMsg)
//                .rsltDetailMsg(errCd.getRsltDetailMsg())
//                .data(null)
//                .build();
//    }
}
