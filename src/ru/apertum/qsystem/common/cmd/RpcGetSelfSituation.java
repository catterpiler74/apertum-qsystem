/*
 *  Copyright (C) 2010 Apertum project. web: www.apertum.ru email: info@apertum.ru
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ru.apertum.qsystem.common.cmd;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import ru.apertum.qsystem.common.model.QCustomer;
import ru.apertum.qsystem.server.model.QService;

/**
 *
 * @author Evgeniy Egorov
 */
public class RpcGetSelfSituation extends JsonRPC20 {

    public RpcGetSelfSituation() {
    }

    public RpcGetSelfSituation(SelfSituation result) {
        this.result = result;
    }

    public static class SelfSituation {

        public SelfSituation() {
        }

        public SelfSituation(LinkedList<SelfService> selfservices, QCustomer customer, LinkedList<QCustomer> postponedList) {
            this.selfservices = selfservices;
            this.customer = customer;
            this.postponedList = postponedList;
        }
        @Expose
        @SerializedName("self_services")
        private LinkedList<SelfService> selfservices;
        @Expose
        @SerializedName("customer")
        private QCustomer customer;

        public QCustomer getCustomer() {
            return customer;
        }

        public void setCustomer(QCustomer customer) {
            this.customer = customer;
        }

        public LinkedList<SelfService> getSelfservices() {
            return selfservices;
        }

        public void setSelfservices(LinkedList<SelfService> selfservices) {
            this.selfservices = selfservices;
        }

        @Expose
        @SerializedName("postponed")
        private LinkedList<QCustomer> postponedList;

        public LinkedList<QCustomer> getPostponedList() {
            return postponedList;
        }

        public void setPostponedList(LinkedList<QCustomer> postponedList) {
            this.postponedList = postponedList;
        }
    }

    public static class SelfService {

        public SelfService() {
        }

        /**
         *
         * @param service услуга по которой данная статистика
         * @param countWait количество ожидающих в этой услуге
         */
        public SelfService(QService service, int countWait) {
            this.serviceName = service.getName();
            this.countWait = countWait;
        }
        @Expose
        @SerializedName("service_name")
        private String serviceName;

        public int getCountWait() {
            return countWait;
        }

        public void setCountWait(int countWait) {
            this.countWait = countWait;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
        @Expose
        @SerializedName("waiting")
        private int countWait;
    }
    @Expose
    @SerializedName("result")
    private SelfSituation result;

    public void setResult(SelfSituation result) {
        this.result = result;
    }

    public SelfSituation getResult() {
        return result;
    }
}
