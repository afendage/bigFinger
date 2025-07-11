//package com.finger.demo;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiParam;
//import lombok.Data;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Data
//@ApiModel
//public class AnchorsReqDTO implements Serializable {
//
//
//    private static final long serialVersionUID = -3126386192345486646L;
//
//    @ApiModelProperty("厅ID")
//    private Long hallId;
//
//    @ApiModelProperty("主播ID")
//    private Long anchorId;
//
//    //用户名/主播账号
//    private String userName;
//
//    //登录密码
//    private String password;
//
//    //余额
//    private String balance;
//
//    //桌边主播上分金额
//    private String amount;
//
//    //美女直播上分金额
//    private String beautyAmount;
//
//    //盐加密
//    private String salt;
//
//    //主播昵称
//    private String nickName;
//
//    //关注度
//    private Integer fansNum;
//
//    //礼物点
//    private Integer giftCredit;
//
//
//    //美女主播大头像地址
//    private String avatar;
//
//    //美女主播小头像地址
//    private String smallAvatar;
//
//    //桌边主播头像地址
//    private String deskAvatar;
//
//    //桌边主播动效头像地址
//    private String deskVideo;
//
//    //桌边主播动效头像地址(深色)
//    private String deskDarkVideo;
//
//    //OB美播头像地址
//    private String beautyAvatar;
//
//    @ApiModelProperty(value = "OB美播专属图片视频")
//    private String beautyFileUrlList;
//
//    //性别，拓展字段，0：男，1：女
//    private Integer sex;
//
//    //直播状态。1：直播中，0：未开播
//    private Integer liveStatus;
//
//    //直播状态。1：美女主播主动下播，2：美女主播被动下播(异常下播)
//    private Integer downBroadcastStatus;
//
//    //累计直播时长，精确到分钟
//    private Integer totalLiveTime;
//
//    //当前桌台号
//    private String currentTableNum;
//
//    //当前直播间人数
//    private Integer liveRoomNum;
//
//    //最近一次上线时间，拓展字段，内部用
//    private LocalDateTime lastLoginTime;
//
//    //主播星级，拓展字段
//    private Integer level;
//
//    //主播签名
//    private String intro;
//
//    //主播年龄，拓展字段
//    private Integer age;
//
//    //国籍
//    private String country;
//
//    //主播账号当前状态，1：启用，0：停用
//    private Integer accountStatus;
//
//    @ApiModelProperty("账号类型：1 内部账号 2 外部账号")
//    private Integer accountType;
//
//    @ApiModelProperty(value = "主播类型：1 夜聊主播 2 非夜聊主播")
//    private Integer nightAnchor;
//
//    //主播显示状态，1：显示，0：隐藏
//    private Integer showStatus;
//
//    //入口状态，1：开启，0：关闭
//    private Integer entranceStatus;
//
//    //修改时间
//    private String updatedAt;
//
//    //修改者
//    private String updatedBy;
//
//    //创建者
//    private String createBy;
//
//    //星座
//    private String constellation;
//
//    //爱好
//    private String hobby;
//
//    //签名
//    private String signature;
//
//    //繁体爱好
//    private String tediousHobby;
//
//    //繁体签名
//    private String tediousSignature;
//
//    //英文爱好
//    private String englishHobby;
//
//    //英文签名
//    private String englishSignature;
//
//    @ApiModelProperty("身高")
//    private String height;
//    @ApiModelProperty("体重")
//    private String weight;
//    @ApiModelProperty("胸围")
//    private String bustLine;
//    @ApiModelProperty("腰围")
//    private String waistLine;
//    @ApiModelProperty("臀围")
//    private String hipLine;
//
//    //新增余额
//    private BigDecimal addbalance=BigDecimal.ZERO;
//
//
//    //确认密码
//    private String confirmPassword;
//
//
//    //账号/昵称
//    private String accountOrName;
//
//
//    //桌边主播游戏账号
//    private String playerName;
//
//    //美女主播游戏账号
//    private String beautyPlayerName;
//
//    //开播时间
//    private LocalDateTime startTime;
//
//    //下播时间
//    private LocalDateTime endTime;
//
//    //美女主播开播场次ID（实际是上播时间戳）
//    private Long anchorFieldId;
//
//    //进入人次
//    private Integer enterNum;
//
//    private Integer language;
//
//    private String dealerNameList;
//}
