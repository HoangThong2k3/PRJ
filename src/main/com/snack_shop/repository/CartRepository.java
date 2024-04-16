package com.snack_shop.repository;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.enums.ProductStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class CartRepository {

    public HashMap<String, ProductResponseDto> getCartFromCookie(Cookie cookie) {
        HashMap<String, ProductResponseDto> cart = new HashMap<>();

        String[] arrItemDetail;

        String category, productName, description, image;
        double price;
        int productId, quantity;
        ProductStatus status;
        Date importDate;
        ProductResponseDto item;
        Base64.Decoder base64Decoder = Base64.getDecoder();
        String encodedString = new String(base64Decoder.decode(cookie.getValue().getBytes()));
        String[] itemsList = encodedString.split("\\|");
        for (String strItem : itemsList) {
            arrItemDetail = strItem.split(",");
            category = arrItemDetail[0].trim();
            productId = Integer.parseInt(arrItemDetail[1].trim());
            productName = arrItemDetail[2].trim();
            description = arrItemDetail[3].trim();
            image = arrItemDetail[4].trim();
            price = Double.parseDouble(arrItemDetail[5].trim());
            quantity = Integer.parseInt(arrItemDetail[6].trim());
            status = ProductStatus.valueOf(arrItemDetail[7].trim());
            importDate = new Date(Long.parseLong(arrItemDetail[8].trim()));
            item = new ProductResponseDto(category, productId, productName, description, image, price, quantity, status, importDate);
            cart.put(String.valueOf(productId), item);
        }
        return cart;
    }

    public Cookie getCookieByName(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public void saveCartToCookie(HttpServletRequest request, HttpServletResponse response, String strItemsInCart, String accountId) {
        String cookieName = "productCart" + accountId;
        Cookie cookieCart = getCookieByName(request, cookieName);
        if (cookieCart != null) {
            cookieCart.setValue(strItemsInCart);
        } else {
            cookieCart = new Cookie(cookieName, strItemsInCart);
        }
        cookieCart.setMaxAge(120);
        response.addCookie(cookieCart);
    }

    public void deleteCartToCookie(HttpServletRequest request, HttpServletResponse response, String accountId) {
        String cookieName = "productCart" + accountId;
        Cookie cookieCart = getCookieByName(request, cookieName);
        if (cookieCart != null) {
            cookieCart.setMaxAge(0);
            response.addCookie(cookieCart);
        }
    }

    public String convertCartToString(List<ProductResponseDto> itemsList) {
        StringBuilder strItemsInCart = new StringBuilder();
        for (ProductResponseDto item : itemsList) {
            strItemsInCart.append(item + "|");
        }
        Base64.Encoder base64Encoder = Base64.getEncoder();
        String encodedString = base64Encoder.encodeToString(strItemsInCart.toString().getBytes());
        return encodedString;
    }

    public List<String> cookieName(HttpServletRequest request) {
        Cookie[] arrCookies = request.getCookies();
        List<String> cookieL = new ArrayList<>();
        if (arrCookies != null) {
            for (Cookie cookie : arrCookies) {
                cookieL.add(cookie.getName());
            }
        }
        return cookieL;
    }


}
