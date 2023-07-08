package com.cavanosa.TutorialStripe.service;

import com.cavanosa.TutorialStripe.http.PaymentIntentDto;
import com.cavanosa.TutorialStripe.http.PedidoDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${stripe.key.secret}")
    String secretKey;

    public PaymentIntent paymentIntent(PaymentIntentDto paymentIntentDto) throws StripeException {
        Stripe.apiKey = secretKey;

        Gson gson = new Gson();
        String paymentIntentJson = gson.toJson(paymentIntentDto.getMetadata().getPedido());
        JsonObject jsonObject = gson.fromJson(paymentIntentJson, JsonObject.class);

        JsonArray articulosArray = jsonObject
                .getAsJsonArray("articulos");


        Map<String, Object> metadata = new HashMap<>();
        List<String> articulos = new ArrayList();

        for (int i = 0; i < articulosArray.size(); i++) {
            JsonObject articulo = articulosArray.get(i).getAsJsonObject();
            String id = articulo.get("id").getAsString();
            articulos.add(id);
        }

        String articulosString = String.join(",", articulos);

        metadata.put("usuario", "Neil 3");
        metadata.put("Articulos", articulosString);


        List<String> paymentMethodTypes = new ArrayList();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentIntentDto.getAmount());
        params.put("currency", paymentIntentDto.getCurrency());
        params.put("description", paymentIntentDto.getDescription());
        params.put("receipt_email", "zneil2v@gmail.com");//not found
        params.put("payment_method_types", paymentMethodTypes);
        params.put("metadata", metadata);
        return PaymentIntent.create(params);
    }

    public PaymentIntent confirm(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");
        paymentIntent.confirm(params);
        return paymentIntent;
    }

    public PaymentIntent cancel(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }
}
