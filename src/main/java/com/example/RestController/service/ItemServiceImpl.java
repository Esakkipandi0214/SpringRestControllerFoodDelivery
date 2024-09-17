package com.example.RestController.service;

import com.example.RestController.ItemRequest;
import com.example.RestController.ItemResponse;
import com.example.RestController.ItemServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ItemServiceGrpc.ItemServiceImplBase {

    @Override
    public void receiveItem(ItemRequest request, StreamObserver<ItemResponse> responseObserver) {
        // Process the received item (e.g., store it in a database)
        String message = "Received item: " + request.getName() + " with price " + request.getPrice();

        ItemResponse response = ItemResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
