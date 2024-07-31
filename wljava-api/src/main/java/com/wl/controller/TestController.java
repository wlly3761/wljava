package com.wl.controller;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test Controller")
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public String test() {
        byte[] key = KeyUtil.generateKey(SM4.ALGORITHM_NAME, 128).getEncoded();

        String content = "test中文";
// 随机生成密钥
        SM4 sm4 = SmUtil.sm4(key);
        String encryptHex = sm4.encryptHex(content);
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
//        String encryptHex = sm4.encryptHex(content);
//        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        return decryptStr;
    }
}
