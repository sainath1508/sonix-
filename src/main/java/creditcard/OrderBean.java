/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package creditcard;

import java.util.Map;
import java.util.Random;

import creditcard.model.Order;

/**
 * Bean that generates and process orders.
 */
public class OrderBean {

    private int counter;
    private Random ran = new Random();

    /**
     * Generates a new order
     */
    public Order generateOrder() {
        Order order = new Order();
        order.setId(++counter);
        order.setItem(counter % 2 == 0 ? "Camel" : "ActiveMQ");
        order.setAmount(ran.nextInt(10) + 1);
        order.setDescription(counter % 2 == 0 ? "Camel in Action" : "ActiveMQ in Action");
        return order;
    }

    /**
     * Processes the order
     *
     * @param order  the order
     * @return the transformed order
     */
    public String processOrder(Order order) {
        return "Processed order id " + order.getId() + " item " + order.getItem() + " of " + order.getAmount() + " copies of " + order.getDescription();
    }

    public Order rowToOrder(Map<String, Object> row) {
        Order order = new Order();
        order.setId((Integer) row.get("id"));
        order.setItem((String) row.get("item"));
        order.setAmount((Integer) row.get("amount"));
        order.setDescription((String) row.get("description"));
        order.setProcessed((Boolean) row.get("processed"));
        return order;
    }
}
