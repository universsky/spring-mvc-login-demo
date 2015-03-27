/**
 * 
 */
package com.baobaotao.result;

/**
 * @author chenguangjian 2015年3月27日 下午4:50:19
 */
public enum ErrorCodeEnum {

	/**
	 * 多个系统 通用错误码 100-XXX-XXX
	 */

	SYS_EXCEPTION("000000000", "系统异常"),

	OPERATION_FAIL("100000000", "操作失败"), OPERATION_SUCCESS("100000001", "操作成功"), GET_PIC_FAIL(
			"100000002", "获取图片失败"), UPLOAD_PIC_FAIL("100000003", "上传图片失败"), DATA_ERROR(
			"100000004", "数据格式有误"),

	PROVINCE_CODE_CANT_EMPTY("100000005", "省份不能为空"), CITY_CODE_CANT_EMPTY(
			"100000006", "市不能为空"), AREA_CODE_CANT_EMPTY("100000007", "区县不能为空"),

	ADD_SUCCESS("100000008", "新增成功"), ADD_FAIL("100000009", "新增失败"), UPDATE_SUCCESS(
			"100000010", "修改成功"), UPDATE_FAIL("100000011", "修改失败"), DELETE_SUCCESS(
			"100000012", "删除成功"), DELETE_FAIL("100000013", "删除失败"),

	USER_NOT_EMPTY("100000014", "请输入用户名"), PASSWORD_NOT_EMPTY("100000015",
			"请输入密码"),

	CORP_NAME_NOT_EMPTY("100000016", "请输入企业名称"), PHONE_NOT_EMPTY("100000017",
			"请输入手机号码"), NEW_PWD_CANT_EMPTY("100000018", "请输入新密码"), NEW_PWD_MISMATCH(
			"100000019", "两次输入的密码不一致"), USER_NAME_OR_PASSWORD("100000020",
			"用户名或密码错误"), USER_NOT_EXIST("100000021", "用户不存在"),

	CONTACTS_NOT_EMPTY("100000022", "请输入联系人"), COMPANY_NOT_EXIST("100000023",
			"该企业不存在"), NAME_CANT_EMPTY("100000024", "请输入姓名"), PERSON_ID_NO_CANT_EMPTY(
			"100000025", "请输入身份证号码"), LOGIN_NAME_CANT_EMPTY("100000026",
			"请输入登录名"), CERT_ADDRESS_EMPTY("100000027", "请输入身份证地址"), PROVINCE_NOT_EMPTY(
			"100000028", "居住所在省份不能为空"), NAME_NOT_EMPTY("100000029", "联系人姓名不能为空"),

	/**
	 * BAOTAO 系统 200-XXX-XXX
	 */

	BAOTAO_MD5_ENCRYPT_ERROR("200000000", "MD5加密异常"),

	// Member
	BAOTAO_TELPHONE_EXIST("200000001", "该手机号已被注册"), BAOTAO_TELPHONE_NO_NOT_EXIST_OR_PWD_ERROR(
			"200000002", "手机号未注册或密码错误"), BAOTAO_COMP_NAME_EXIST("200000003",
			"该企业名称已被注册"),

	BAOTAO_REGISTER_CODE("200000004",
			"感谢您的注册, 您的注册码为:{0}. www.qjdchina.com【仟金顶】"), BAOTAO_REGISTER_CODE_CANT_EMPTY(
			"200000005", "注册码不能为空"), BAOTAO_REGISTER_CODE_EXPIRED("200000006",
			"该注册码无效或者已经过期"), BAOTAO_REGISTER_CODE_SEND_AGAIN("200000007",
			"注册码已发,请1分钟后再次尝试"),

	BAOTAO_NEW_PWD_SAME_AS_OLD("200000008", "新密码不能与现密码相同"), BAOTAO_PWD_REST(
			"200000009", "密码重置成功"), BAOTAO_MEBERID_NOT_EMPTY("200000010",
			"会员ID不能为空"), BAOTAO_MEMBER_NOT_EXIST("200000011", "该会员不存在"),

	// company
	BAOTAO_EMAIL_EXIST("200000012", "邮箱已被注册"), BAOTAO_EMAIL_NO_EXIST(
			"200000013", "邮箱尚未注册"), BAOTAO_BIZ_REG_NO_EXIST("200000014",
			"该工商注册号已被注册"), BAOTAO_BIZ_REG_CANT_EMPTY("200000015", "工商注册号不能为空"), BAOTAO_BIZ_REG_START_DATE_CANT_EMPTY(
			"200000016", "经营开始时间不能为空"), BAOTAO_REG_ADDRESS_CANT_EMPTY(
			"200000017", "注册地址不能为空"),

	// Relationship
	BAOTAO_CONTACT_HISTORY_NOT_EXIST("200000018", "该历史联系人不存在"), BAOTAO_RELATIONSHIP_NOT_EMPTY(
			"200000019", "历史关系不存在"), BAOTAO_RELTYPE_CANT_EMPTY("200000020",
			"关系类型不能为空"), BAOTAO_RELATIONSHIP_NO_EXIST("200000021",
			"公司与个人实体关系不存在"),

	// 上传文件
	BAOTAO_FILE_NAME_CANT_EMPTY("200000021", "文件名不能为空"), BAOTAO_FILE_PATH_CANT_EMPTY(
			"200000022", "文件路径不能为空"), BAOTAO_UPLD_META_CANT_EMPTY("200000023",
			"资料类型不能为空"),

	BAOTAO_LOGIN_NAME_NOT_EXIST("200000024", "登录名不存在"),

	/**
	 * BAOTAO_fnt 300-XXX-XXX
	 */

	BAOTAO_FNT_VERIFY_CODE_NOT_EMPTY("300000001", "请输入验证码"), BAOTAO_FNT_VERIFY_CODE_INPUT_ERROR(
			"300000002", "验证码输入不正确，请重新输入"), BAOTAO_FNT_VERIFY_CODE_FAILURE(
			"300000003", "验证码已失效，请重新刷新验证码"), BAOTAO_FNT_VERIFY_CODE_PHONE_FAILURE(
			"300000004", "短信验证码不存在或已失效，请重新获取"), BAOTAO_FNT_CONFIRM_PASSWORD_NOT_EMPTY(
			"300000005", "请输入确认密码"), BAOTAO_FNT_VERIFY_CODE_TIMED_OUT(
			"300000006", "验证码已超时,请重新获取"), BAOTAO_FNT_SEND_SMS_SUCCESS(
			"300000007", "短信验证码发送成功"), BAOTAO_FNT_SEND_SMS_FAIL("300000008",
			"短信验证码发送失败"),

	// 合作伙伴 ：100-010-XXX
	BAOTAO_FNT_COODS_CATS_NOT_EMPTY("300000009", "请选择品类"), BAOTAO_FNT_SUPPLIERS_NOT_EMPTY(
			"3000000010", "请输入供应商"), BAOTAO_FNT_APP_ID_NOT_EXIST("3000000011",
			"会员申请表不存在"),

	BAOTAO_FNT_REGISTER_SUCCESS("300000012", "恭喜您，注册成功"), BAOTAO_LOGIN_SUCCESS(
			"300000013", "登陆成功");

	private String code;
	private String msg;

	private ErrorCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ErrorCodeEnum [code=" + code + ", msg=" + msg + "]";
	}

}
