package com.adidas.santarromana.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Subscription public model")
public class Subscription {

    @ApiModelProperty(value = "Subscription id")
    private Long subscriptionId;

    @ApiModelProperty(value = "Subscription email", required = true)
    private String email;

    @ApiModelProperty(value = "Subscription firstName", required = true)
    private String firstName;

    @ApiModelProperty(value = "Subscription gender")
    private String gender;

    @ApiModelProperty(value = "Subscription dateOfBirth")
    private Date dateOfBirth;

    @ApiModelProperty(value = "Subscription consent", required = true)
    private boolean consent;

    @ApiModelProperty(value = "Subscription newsletterId", required = true)
    private String newsletterId;

    @ApiModelProperty(value = "Subscription notified")
    private boolean notified;
}
