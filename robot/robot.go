package main

import (
	"bytes"
	"crypto/hmac"
	"crypto/sha256"
	"encoding/base64"
	"encoding/json"
	"fmt"
	"github.com/robfig/cron"
	"io/ioutil"
	"net/http"
	"strconv"
	"time"
)

const (
	waterUrl = "***"
	secret = "***"
)

type request struct {
	Timestamp string `json:"timestamp"`
	Sign      string `json:"sign"`
	MsgType   string `json:"msg_type"`
	Content   content `json:"content"`
}

type content struct {
	Text string `json:"text"`
}

func GenSign(secret string, timestamp int64) (string, error) {
	//timestamp + key 做sha256, 再进行base64 encode
	stringToSign := fmt.Sprintf("%v", timestamp) + "\n" + secret

	var data []byte
	h := hmac.New(sha256.New, []byte(stringToSign))
	_, err := h.Write(data)
	if err != nil {
		return "", err
	}

	signature := base64.StdEncoding.EncodeToString(h.Sum(nil))
	return signature, nil
}


func main() {
	c := cron.New(cron.WithSeconds()) //精确到秒

	//定时任务
	spec := "00 00 9,11,14,16,19 * * ?"
	//spec := "*/5 * * * * ?"
	_, err := c.AddFunc(spec, Dohttp)
	if err != nil {
		return 
	}

	c.Start()
	select {

	}
}


func Dohttp() {
	sign, err := GenSign(secret, time.Now().Unix())
	if err != nil {
		fmt.Println(err)
		return
	}

	ctx := content{Text: "该喝水啦！！快点喝水～～"}

	req := request{
		Timestamp: strconv.Itoa(int(time.Now().Unix())),
		Sign:      sign,
		MsgType:   "text",
		Content: ctx,
	}

	body,err := json.Marshal(req)
	if err != nil {
		fmt.Println(err)
		return
	}

	resp, err := http.Post(waterUrl, "application/json", bytes.NewReader(body))
	if err != nil {
		fmt.Println(err)
		return
	}

	var result map[string]interface{}
	respbody,err := ioutil.ReadAll(resp.Body)
	if err == nil {
		err = json.Unmarshal(respbody, &result)
	}
}
